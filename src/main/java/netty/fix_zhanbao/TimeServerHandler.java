package netty.fix_zhanbao;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * TimeServerHandler负责对网络事件进行读写操作
 * @author huangy on 2020-05-04
 */
public class TimeServerHandler extends ChannelHandlerAdapter {

    private int counter;

    /**
     * 以换行符作为分隔，每一行就调用一次channelRead
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        String body = (String)msg;

        System.out.println("server receive req=" + body + "    counter=" + ++counter);

        String currentTimeStr;
        if ("QUERY TIME ORDER".equalsIgnoreCase(body)) {
            currentTimeStr = new Date().toString();
        } else {
            currentTimeStr = "BAD ORDER";
        }

        currentTimeStr = currentTimeStr + System.getProperty("line.separator");

        ByteBuf response = Unpooled.copiedBuffer(currentTimeStr.getBytes(StandardCharsets.UTF_8));

        // 异步发送应答消息给客户端
        ctx.writeAndFlush(response);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
