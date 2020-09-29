package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="PREMIUM_INSURANCEPOLICY")
@NamedQuery(name="HQL_INSERT_TRANSFER_POLICIES",
                                 query="INSERT INTO com.nt.entity.PremiumInsurancePolicy(pid,policyName,company,policyType,tenure) SELECT i.policyId,i.policyName,i.company,i.policyType,i.tenure FROM com.nt.entity.InsurancePolicy as i WHERE i.tenure>=:min")
public class PremiumInsurancePolicy implements Serializable {
	@Id
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
