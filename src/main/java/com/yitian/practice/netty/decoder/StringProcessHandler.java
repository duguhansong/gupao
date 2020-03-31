package com.yitian.practice.netty.decoder;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

public class StringProcessHandler extends ChannelHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            ByteBuf m = (ByteBuf) msg;
            System.out.println(m.toString(Charset.forName("utf-8")));

        }finally {
            ReferenceCountUtil.release(msg);//buf缓冲区使用完了，必须释放
        }
	}


}
