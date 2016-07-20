package com.youngjee.springcore.env;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware, InitializingBean {

	private Environment env;
	private String adminId;
	private String adminPw;

	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet method call!");
		setAdminId(env.getProperty("admin.id") );
		setAdminPw(env.getProperty("admin.pw"));

	}

	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("setEnvironment method call!");
		setEnv(environment);

	}

}
