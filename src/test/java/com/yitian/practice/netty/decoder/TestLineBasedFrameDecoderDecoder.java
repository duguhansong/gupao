package com.yitian.practice.netty.decoder;

import java.nio.charset.Charset;

import org.junit.Test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class TestLineBasedFrameDecoderDecoder {
	
	@Test
	public void testLineBasedFrameDecoder() {
		ChannelInitializer<EmbeddedChannel> initial = new ChannelInitializer<EmbeddedChannel>() {
			@Override
			protected void initChannel(EmbeddedChannel ch) throws Exception {
				ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
				ch.pipeline().addLast(new StringDecoder(Charset.forName("utf-8")));
				ch.pipeline().addLast(new StringProcessHandler());
			}
		};
		EmbeddedChannel channel = new EmbeddedChannel(initial);
		for(int j = 0; j < 100; j++) {
			ByteBuf buf = Unpooled.buffer();
			String s = "i am "  + j;
			buf.writeBytes(s.getBytes(Charset.forName("utf-8")));
			buf.writeBytes("\r\n".getBytes(Charset.forName("utf-8")));
			channel.writeOutbound(buf);
		}
	}

	@Test
	public void testLengthFieldBasedFrameDecoder() {

	}
}
