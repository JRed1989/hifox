package org.edf.hifox.core.invoker;

import java.util.Map;

import org.edf.hifox.core.channel.Channel;
import org.edf.hifox.core.constant.ServiceDirConstant;
import org.edf.hifox.core.datatransfer.Message;
import org.edf.hifox.core.register.MetaRegistry;
import org.edf.hifox.core.register.channel.registry.xmlbean.ChannelDef;
import org.edf.hifox.core.reqinfo.OutboundRequestInfo;
import org.edf.hifox.core.util.SwapAreaUtil;

/**
 * 
 * @author WangYang
 *
 */
public class DefaultChannelInvoker implements Invoker<String, OutboundRequestInfo> {
	
	private MetaRegistry<ChannelDef> registry;

	public void setRegistry(MetaRegistry<ChannelDef> registry) {
		this.registry = registry;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public String invoke(OutboundRequestInfo data) {
		String targetNodeId = SwapAreaUtil.getOutboundServiceDirItem().get(ServiceDirConstant.TARGET_NODE_ID);
		String respMsgStr;
		if (data.getRequestMessage() instanceof Message)
			respMsgStr = sendMsg(targetNodeId, SwapAreaUtil.getOutboundServiceId(), data.getContentString());
		else if (data.getRequestMessage() instanceof Map)
			respMsgStr = sendMsg(targetNodeId, SwapAreaUtil.getOutboundServiceId(), (Map<String, String>)data.getRequestMessage());
		else
			respMsgStr = sendMsg(targetNodeId, SwapAreaUtil.getOutboundServiceId(), data.getContentString());
		
		SwapAreaUtil.setOutboundResponseMsgStr(respMsgStr);
		
		return respMsgStr;
	}

	private String sendMsg(String targetNodeId, String serviceId, String reqMsgStr) {
		ChannelDef channelDef = registry.getMeta(targetNodeId);
		Channel channel = channelDef.getChannel();
		return channel.sendMsg(serviceId, reqMsgStr);
	}

	private String sendMsg(String targetNodeId, String serviceId, Map<String, String> msg) {
		ChannelDef channelDef = registry.getMeta(targetNodeId);
		Channel channel = channelDef.getChannel();
		return channel.sendMsg(serviceId, msg);
	}
	
}
