package com.nt.entity;

import java.io.Serializable;

public class InsurancePolicy implements Serializable {
	private Long policyId;
	private String policyName;
	private String policyType;
	private String company;
	private Integer tenure;
	
	public InsurancePolicy() {
		System.out.println("InsurancePolicy:: 0-param consructor"+this.getClass());
	}
	
	//gettes && setters  (alt+shift+s,r
	public final Long  getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}
	public final String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public final String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public final  String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public final Integer getTenure() {
		return tenure;
	}
	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}
	
	@Override
	public String toString() {
		return "InsurancePolicy [policyId=" + policyId + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", company=" + company + ", tenure=" + tenure + "]";
	}
	
	

}
