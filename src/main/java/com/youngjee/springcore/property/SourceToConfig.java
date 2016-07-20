package com.youngjee.springcore.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class SourceToConfig {
	
	@Value("${admin.id}")
	private String adminId;
	
	@Value("${admin.pw}")
	private String adminPw;
	
	@Value("${sub_adminId}")
	private String sub_adminId;
	
	@Value("${sub_adminPw}")
	private String sub_adminPw;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer Properties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		
		Resource [] resources = new Resource[2];
		resources[0] = new ClassPathResource("admin.properties");
		resources[1] = new ClassPathResource("sub_admin.properties");
		
		configurer.setLocations(resources);
		
		return configurer;
	}
	
	@Bean
	public AdminProperty adminConfig() {
		AdminProperty adminProperty = new AdminProperty();
		adminProperty.setAdminId(adminId);
		adminProperty.setAdminPw(adminPw);
		adminProperty.setSub_adminId(sub_adminId);
		adminProperty.setSub_adminPw(sub_adminPw);
		
		return adminProperty;
	}
	
	
}
