package com.youngjee.springcore.factorybeanmethod;

public class FactoryBeanDTO {

	private long id;
	private float depositAmount;
	private int tenure;
	private String email;
	
	public FactoryBeanDTO(long id, float depositAmount, int tenure, String email) {
		super();
		this.id = id;
		this.depositAmount = depositAmount;
		this.tenure = tenure;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(float depositAmount) {
		this.depositAmount = depositAmount;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "FactoryBeanDTO [id=" + id + ", depositAmount=" + depositAmount + ", tenure=" + tenure + ", email="
				+ email + "]";
	}
	
}
