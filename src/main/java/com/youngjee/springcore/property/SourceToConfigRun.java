package com.youngjee.springcore.property;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("run")
public class SourceToConfigRun {
	
	@Bean
	public ServerInfoDTO serverInfo() {
		ServerInfoDTO serverInfoDTO = new ServerInfoDTO();
		serverInfoDTO.setIpNum("realhost");
		serverInfoDTO.setPortNum("80");
		
		return serverInfoDTO;
	}
}
