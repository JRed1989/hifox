package org.edf.hifox.core.register.channel;

import org.edf.hifox.core.channel.Channel;
import org.edf.hifox.core.channel.HttpChannel;
import org.edf.hifox.core.channel.endpoint.http.HttpEndpoint;
import org.edf.hifox.core.constant.ChannelConstant;
import org.edf.hifox.core.constant.LogCodeConstant;
import org.edf.hifox.core.log.Logger;
import org.edf.hifox.core.log.LoggerFactory;
import org.edf.hifox.core.parser.Parser;
import org.edf.hifox.core.register.AbstractRegister;
import org.edf.hifox.core.register.channel.registry.ChannelRegistry;
import org.edf.hifox.core.register.channel.registry.xmlbean.ChannelCfg;
import org.edf.hifox.core.register.channel.registry.xmlbean.ChannelDef;
import org.edf.hifox.core.register.channel.registry.xmlbean.HttpEndpointDef;
import org.springframework.core.io.Resource;

/**
 * 
 * @author WangYang
 *
 */
public class ChannelConfigRegister extends AbstractRegister {
	
	private static final Logger logger = LoggerFactory.getLogger(ChannelConfigRegister.class);
	
	private Parser<ChannelCfg> parser;
	private ChannelRegistry registry;
	
	public void setParser(Parser<ChannelCfg> parser) {
		this.parser = parser;
	}

	public void setRegistry(ChannelRegistry registry) {
		this.registry = registry;
	}


	@Override
	public void regist(Resource[] resources) throws Exception {
		logger.info(LogCodeConstant.REG00005);
		ChannelCfg result;
		for (Resource resource : resources) {
			logger.info(LogCodeConstant.REG00006, new Object[]{resource.getURI()});
			result = parser.parse(resource);
			
			Channel channel;
			for (ChannelDef channelDef : result.getChannels()) {
				if (ChannelConstant.HTTP.equals(channelDef.getType())) {
					HttpEndpointDef httpEndpointDef = channelDef.getHttpEndpointDef();
					
					HttpEndpoint endpoint = new HttpEndpoint();
					endpoint.setHttpEndpointDef(httpEndpointDef);
					
					channel = new HttpChannel(endpoint, channelDef.getRetryCount(), channelDef.getDelayTime());
					channelDef.setChannel(channel);
				}
				
				registry.addUniqueMeta(channelDef.getId(), channelDef);
			}
		}
		
	}
	
}
