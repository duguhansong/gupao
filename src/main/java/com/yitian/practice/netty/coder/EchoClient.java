package com.yitian.practice.netty.coder;

import java.util.ArrayList;
import java.util.List;

import com.yitian.practice.netty.coder.vo.UserInfo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

public class EchoClient {

	private  void start() throws InterruptedException {
		EventLoopGroup  work = new NioEventLoopGroup();
		Bootstrap strap = new Bootstrap();
		strap.group(work);
		strap.channel(NioSocketChannel.class);
		strap.handler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast("frameDecoder",new LengthFieldBasedFrameDecoder(635535, 0, 2,0,2));
				ch.pipeline().addLast("msgpack decoder",new MsgpackDecoder() );
				ch.pipeline().addLast("frameEncoder",new LengthFieldPrepender(2));
				ch.pipeline().addLast("msgpack encoder",new MsgpackEncoder() );
				ch.pipeline().addLast(new EchoClientHandler());
			}
			
		});
		ChannelFuture f = strap.connect("127.0.0.1",8080).sync();
		f.channel().closeFuture().sync();
		work.shutdownGracefully();
		System.out.println("client shutdowned...");
	}
	public static void main(String[] args) {
		try {
			new EchoClient().start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
class EchoClientHandler extends ChannelHandlerAdapter{

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("client active");
		List<UserInfo> users = buildUserInfo();
		for(UserInfo user:users) {
			ctx.write(user);
		}
		ctx.flush();
	}
	
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("client receive message:" + msg);
	}


	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		System.out.println("client read complete" );
		ctx.flush();
	}


	private List<UserInfo> buildUserInfo(){
		List<UserInfo> users = new ArrayList<UserInfo>();
		for(int i = 0; i  < 1000; i++) {
			UserInfo user = new UserInfo();
			user.setUserName("abcdefg--->" + i);
			user.setAge(i + 10);
			user.setUserId(i+"");
			users.add(user);
		}
		return users;
	}
}
