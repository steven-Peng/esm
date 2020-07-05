package net.esm.modules.sys.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * netty 服务端初始化器
 * pyl
 */
public class NettyServerChannelInitializer extends ChannelInitializer<SocketChannel> {

	private static final Logger LOGGER = LoggerFactory.getLogger(NettyServerChannelInitializer.class);

	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception {
		//添加编解码
		socketChannel.pipeline().addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
		socketChannel.pipeline().addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
		socketChannel.pipeline().addLast(new NettyServerHandler());
	}
}
