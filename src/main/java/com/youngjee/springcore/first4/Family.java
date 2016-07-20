package com.youngjee.springcore.first4;

public class Family {
	String papaName;
	String mamiName;
	String sisterName;
	String brothername;
	
	public Family(String papaName, String mamiName) {
		this.papaName = papaName;
		this.mamiName = mamiName;
	}

	public String getPapaName() {
		return papaName;
	}

	public void setPapaName(String papaName) {
		this.papaName = papaName;
	}

	public String getMamiName() {
		return mamiName;
	}

	public void setMamiName(String mamiName) {
		this.mamiName = mamiName;
	}

	public String getSisterName() {
		return sisterName;
	}

	public void setSisterName(String sisterName) {
		this.sisterName = sisterName;
	}

	public String getBrothername() {
		return brothername;
	}

	public void setBrothername(String brothername) {
		this.brothername = brothername;
	}
}
