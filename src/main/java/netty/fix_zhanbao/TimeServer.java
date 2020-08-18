package netty.fix_zhanbao;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author huangy on 2020-05-04
 */
public class TimeServer {

    public void bind(int port) throws Exception {
        /*
         * 配置服务端的NIO线程组
         * NioEventLoopGroup是个线程组，它包含了一组NIO线程，专门用于网络事件的处理。实际上它们就是Reactor线程组。
         * 这里创建2个线程组的原因是：
         * （1）一个用于服务端接收客户端的连接（bossGroup）
         * （2）另一个用于监听SocketChannel的网络读写事件（workerGroup）
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            /*
             * ServerBootstrap是用于启动NIO服务端的辅助启动类，目的是降低服务端开发的复杂度
             */
            ServerBootstrap b = new ServerBootstrap();

            b.group(bossGroup, workerGroup)
                    // 绑定NIO管道
                    .channel(NioServerSocketChannel.class)
                    // 设置TCP参数，这里是设置请求队列的长度，元素个数超过该长度则拒绝请求
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    // IO事件的处理类，类似于Reactor模式中的handler类，主要用于处理网络IO事件
                    .childHandler(new ChildChannelHandler());

            // 绑定端口，同步等待成功
            ChannelFuture f = b.bind(port).sync();

            // 等待服务端链路关闭后，main函数才退出
            f.channel().closeFuture().sync();

        } finally {
            // 优雅退出，释放服务器资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
            socketChannel.pipeline().addLast(new StringDecoder());
            socketChannel.pipeline().addLast(new TimeServerHandler());
        }
    }

    public static void main(String[] args) throws Exception {
        new TimeServer().bind(8080);
    }
}
