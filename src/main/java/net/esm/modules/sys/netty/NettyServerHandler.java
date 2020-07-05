package net.esm.modules.sys.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * netty 服务端响应处理器
 * pyl
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(NettyServerHandler.class);

	/**
	 * 客户端连接会触发
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		LOGGER.info("连接了客户端 Channel active......");
	}

	/**
	 * 客户端发消息会触发
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		LOGGER.info("服务器收到消息: {}", msg.toString());
		ctx.writeAndFlush("你也好哦");
	}

	/**
	 * 发生异常触发
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}
