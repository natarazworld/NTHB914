package com.nt.entity;

public interface IProject {
	public String getProjName() ;
	public void setProjName(String projName) ;
	public Integer getTeamSize() ;
	public void setTeamSize(Integer teamSize);
	public String getCompany(); 
	public void setCompany(String company) ;
	public void setProjId(Long projId) ;
	public Long getProjId();
	
}
