package com.nt.entity;

import java.io.Serializable;

import org.hibernate.annotations.Proxy;

import jdk.jfr.Label;

public class PremiumInsurancePolicy implements Serializable {
	private Long pid;
	private String policyName;
	private String policyType;
	private String company;
	private Integer tenure;
	
	public PremiumInsurancePolicy() {
		System.out.println("PremiumInsurancePolicy:: 0-param consructor");
	}
	
	//gettes && setters  (alt+shift+s,r
	public  Long  getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public  String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public  String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public   String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public  Integer getTenure() {
		return tenure;
	}
	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}
	
	@Override
	public String toString() {
		return "PremimumInsurancePolicy [policyId=" + pid + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", company=" + company + ", tenure=" + tenure + "]";
	}
	
	

}
