package com.nt.entity;


import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;


@Entity
@DynamicInsert(true) //or  @DynamicInsert(value=true)  
//@DynamicUpdate(true)
//@Table(name="PROJECT")
@Proxy(lazy = true,proxyClass =IProject.class )
public final class Project implements Serializable,IProject {
		private Long projId;
		private String projName;
		private  Integer teamSize;
		private  String company;
		
		@Id
		@Column(name="PROJID",length =10 )
		@Type(type="long")
		
		public Long getProjId() {
			return projId;
		}
		public void setProjId(Long projId) {
			this.projId = projId;
		}
		
		@Column(name="PROJNAME",length = 15,unique = true,nullable = false)
		@Type(type="string")
		public String getProjName() {
			return projName;
		}
		public void setProjName(String projName) {
			this.projName = projName;
		}
		
		@Column(name="TEAMSIZE",length = 5)
		@Type(type="int")
		public Integer getTeamSize() {
			return teamSize;
		}
		public void setTeamSize(Integer teamSize) {
			this.teamSize = teamSize;
		}
		
		@Column(name="COMPANY",length = 20)
		@Type(type="string")
		//@Transient
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		
		
		
		@Override
		public String toString() {
			return "Project [projId=" + projId + ", projName=" + projName + ", teamSize=" + teamSize + ", company="
					+ company + "]";
		}
	
		
	
	
	

}
