package com.youngjee.springcore.property;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ConfigSwitchMain {

	public static void main(String[] args) {
//		String config = "dev";
		String config = "run";
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.getEnvironment().setActiveProfiles(config);
		
		context.load("springcore.property_dev.xml","springcore.property_run.xml");
		context.refresh();
		
		ServerInfoDTO serverInfoDTO = (ServerInfoDTO) context.getBean("serverinfo");
		System.out.println(serverInfoDTO.toString());
	}

}
