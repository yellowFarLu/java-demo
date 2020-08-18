package netty.zhanbao;

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

    private int counter;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        // ByteBuf类似NIO中ByteBuffer，不过它提供了更加强大和灵活的能力
        ByteBuf buf = (ByteBuf)msg;

        // readableBytes获取缓冲区可读的字节数
        byte[] req = new byte[buf.readableBytes()];

        // 将缓冲区中的字节数组赋值到req中
        buf.readBytes(req);

        String body = new String(req, StandardCharsets.UTF_8)
                .substring(0, req.length - System.getProperty("line.separator").length());
        System.out.println("server receive req=" + body + "    counter=" + ++counter);

        String currentTimeStr;
        if ("QUERY TIME ORDER".equalsIgnoreCase(body)) {
            currentTimeStr = new Date().toString();
        } else {
            currentTimeStr = "BAD ORDER";
        }

        ByteBuf response = Unpooled.copiedBuffer(currentTimeStr.getBytes(StandardCharsets.UTF_8));

        // 异步发送应答消息给客户端
        ctx.writeAndFlush(response);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
