package net.esm.modules.sys.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import net.esm.common.utils.SpringContextUtils;
import net.esm.modules.business.enums.Constant;
import net.esm.modules.business.service.BusiDeviceService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.DependsOn;

/**
 * netty 服务端响应处理器
 * pyl
 */
@DependsOn("springContextUtils")
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(NettyServerHandler.class);
	private static BusiDeviceService busiDeviceService = SpringContextUtils.getBean("busiDeviceService", BusiDeviceService.class);

	/**
	 * 客户端连接会触发
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		LOGGER.info("Channel active......");
	}

	/**
	 * 客户端发消息会触发
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ctx.writeAndFlush("ok\r\n");

		try {
			//TODO:增加时间校正功能
			String[] params = StringUtils.split(msg.toString(), ":");
			if (params[1].length()==12) {
				busiDeviceService.saveDeviceInfo(params, ctx.channel().remoteAddress().toString());
			}
		}catch (Exception e){
			LOGGER.info(e.getMessage());
		}
	}

	/**
	 * 发生异常触发
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		if (!(cause.getMessage().contains("中止了一个已建立的连接") || cause.getMessage().contains("远程主机强迫关闭了一个现有的连接"))){
			cause.printStackTrace();
		}
		String address = ctx.channel().remoteAddress().toString();
		updateStatusAndSetLog(address);
		ctx.close();
		super.exceptionCaught(ctx, cause);
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		LOGGER.info("客户端断开了: " + ctx.channel().remoteAddress().toString());
		String address = ctx.channel().remoteAddress().toString();
		updateStatusAndSetLog(address);
		super.handlerRemoved(ctx);
	}

	private void updateStatusAndSetLog(String address){
		busiDeviceService.updateStatusAndSetLog(Constant.STATUS_LOST_CONNECTION, address);
	}
}
