package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
@Entity
@Table(name="BANK_ACCOUNT")
@FilterDef(name = "FILTER_BANKACCOUNT_STATUS",
                      parameters = { @ParamDef(name="accountType1",type = "string"),
                    		                       @ParamDef(name="accountType2",type = "string")
                                                 }
                    )
@Filter(name ="FILTER_BANKACCOUNT_STATUS",
                               condition = "STATUS NOT IN(:accountType1,:accountType2)")
public class BankAccount implements Serializable {
	@Id
	@GeneratedValue
	private int acno;
	private String holderName;
	private float balance;
	private  String status;
	public int getAcno() {
		return acno;
	}
	public void setAcno(int acno) {
		this.acno = acno;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BankAccount [acno=" + acno + ", holderName=" + holderName + ", balance=" + balance + ", status="
				+ status + "]";
	}
	
	
	
	
	

}
