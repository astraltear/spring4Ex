package sample.spring.chapter03.bankapp.domain;

import java.util.Date;

public class BankStatement {
	private Date transactionDate;
	private double amount;
	private String transactionType;
	private String referenceNumber;
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	@Override
	public String toString() {
		return "BankStatement [transactionDate=" + transactionDate
				+ ", amount=" + amount + ", transactionType=" + transactionType
				+ ", referenceNumber=" + referenceNumber + "]";
	}
	
	
}
