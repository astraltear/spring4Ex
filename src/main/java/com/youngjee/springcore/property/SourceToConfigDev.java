package com.youngjee.springcore.property;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class SourceToConfigDev {
	
	@Bean
	public ServerInfoDTO serverInfo() {
		ServerInfoDTO serverInfoDTO = new ServerInfoDTO();
		serverInfoDTO.setIpNum("localhost");
		serverInfoDTO.setPortNum("8080");
		
		return serverInfoDTO;
	}
}
