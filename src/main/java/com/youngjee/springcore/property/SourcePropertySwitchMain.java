package com.youngjee.springcore.property;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SourcePropertySwitchMain {

	public static void main(String[] args) {
//		String config = "dev";
		String config = "run";
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles(config);
		context.register(SourceToConfigDev.class,SourceToConfigRun.class);
		context.refresh();
		
		ServerInfoDTO serverInfoDTO = (ServerInfoDTO) context.getBean("serverInfo");
		System.out.println(serverInfoDTO.toString());
	}

}
