package com.nt.entity;

import java.io.Serializable;

public interface IInsurancePolicy{
	public Long  getPolicyId();
	public void setPolicyId(Long policyId) ;
	public  String getPolicyName(); 
	public void setPolicyName(String policyName); 
	public  String getPolicyType(); 
	public void setPolicyType(String policyType);
	public   String getCompany(); 
	public void setCompany(String company) ;
	public  Integer getTenure();
	public void setTenure(Integer tenure) ;
}
