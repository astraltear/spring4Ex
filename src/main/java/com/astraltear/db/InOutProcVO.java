package com.astraltear.db;

public class InOutProcVO {
	private int param1;
	private int param2;
	private String param3;
	public int getParam1() {
		return param1;
	}
	public void setParam1(int param1) {
		this.param1 = param1;
	}
	public int getParam2() {
		return param2;
	}
	public void setParam2(int param2) {
		this.param2 = param2;
	}
	public String getParam3() {
		return param3;
	}
	public void setParam3(String param3) {
		this.param3 = param3;
	}
	@Override
	public String toString() {
		return "InOutProcVO [param1=" + param1 + ", param2=" + param2 + ", param3=" + param3 + "]";
	}
	
}
