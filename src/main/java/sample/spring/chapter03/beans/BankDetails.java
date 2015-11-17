package sample.spring.chapter03.beans;

import java.util.Arrays;
import java.util.Currency;
import java.util.Properties;

public class BankDetails {
	private String bankName;
	private byte[] bankPrimaryBusiness;
	private char[] headOfficeAddress;
	private char privateBank;
	private Currency primaryCurrency;
	private String dateOfInception;
	private Properties branchAddresses;
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public byte[] getBankPrimaryBusiness() {
		return bankPrimaryBusiness;
	}
	public void setBankPrimaryBusiness(byte[] bankPrimaryBusiness) {
		this.bankPrimaryBusiness = bankPrimaryBusiness;
	}
	public char[] getHeadOfficeAddress() {
		return headOfficeAddress;
	}
	public void setHeadOfficeAddress(char[] headOfficeAddress) {
		this.headOfficeAddress = headOfficeAddress;
	}
	public char getPrivateBank() {
		return privateBank;
	}
	public void setPrivateBank(char privateBank) {
		this.privateBank = privateBank;
	}
	public Currency getPrimaryCurrency() {
		return primaryCurrency;
	}
	public void setPrimaryCurrency(Currency primaryCurrency) {
		this.primaryCurrency = primaryCurrency;
	}
	public String getDateOfInception() {
		return dateOfInception;
	}
	public void setDateOfInception(String dateOfInception) {
		this.dateOfInception = dateOfInception;
	}
	public Properties getBranchAddresses() {
		return branchAddresses;
	}
	public void setBranchAddresses(Properties branchAddresses) {
		this.branchAddresses = branchAddresses;
	}
	@Override
	public String toString() {
		return "BankDetails [bankName=" + bankName + ", bankPrimaryBusiness="
				+ Arrays.toString(bankPrimaryBusiness) + ", headOfficeAddress="
				+ Arrays.toString(headOfficeAddress) + ", privateBank="
				+ privateBank + ", primaryCurrency=" + primaryCurrency
				+ ", dateOfInception=" + dateOfInception + ", branchAddresses="
				+ branchAddresses + "]";
	}
	
}