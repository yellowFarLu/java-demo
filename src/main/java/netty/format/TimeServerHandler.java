package netty.format;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * TimeServerHandler负责对网络事件进行读写操作
 * @author huangy on 2020-05-04
 */
public class TimeServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        // ByteBuf类似NIO中ByteBuffer，不过它提供了更加强大和灵活的能力
        ByteBuf buf = (ByteBuf)msg;

        // readableBytes获取缓冲区可读的字节数
        byte[] req = new byte[buf.readableBytes()];

        // 将缓冲区中的字节数组赋值到req中
        buf.readBytes(req);

        String body = new String(req, StandardCharsets.UTF_8);
        System.out.println("server receive req=" + body);
        String currentTimeStr = new Date().toString();
        ByteBuf response = Unpooled.copiedBuffer(currentTimeStr.getBytes(StandardCharsets.UTF_8));

        // 异步发送应答消息给客户端
        ctx.write(response);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        /*
         * flush方法作用是将发送缓冲区中的消息写入到SocketChannel发送给对方。
         * 从性能的角度考虑，为了防止频繁的唤醒Selector进行消息的发送，Netty的write方法
         * 并不直接将消息写入SocketChannel，调用write方法仅将消息放入到发送缓冲区中，
         * 再通过调用flush方法，将发送缓冲区中的消息全部写到SocketChannel。
         */
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
