package com.yitian.practice.netty.coder;

import java.util.List;

import org.msgpack.MessagePack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

public class MsgpackDecoder extends MessageToMessageDecoder<ByteBuf>{

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
		System.out.println("decode");
		final int length = msg.readableBytes();
		final byte[] array = new byte[length];
		msg.readBytes(array);
		MessagePack msgpack = new MessagePack();
		out.add(msgpack.read(array));
	}
}
