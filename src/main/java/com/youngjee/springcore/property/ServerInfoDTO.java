package com.youngjee.springcore.property;

public class ServerInfoDTO {
	
	private String ipNum;
	private String portNum;
	
	public String getIpNum() {
		return ipNum;
	}
	public void setIpNum(String ipNum) {
		this.ipNum = ipNum;
	}
	public String getPortNum() {
		return portNum;
	}
	public void setPortNum(String portNum) {
		this.portNum = portNum;
	}
	@Override
	public String toString() {
		return "ServerInfoDTO [ipNum=" + ipNum + ", portNum=" + portNum + "]";
	}
	
}
