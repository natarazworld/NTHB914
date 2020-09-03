package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

@Entity
public class MobileCustomer  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer cno;
	@Column(length=20)
	@Type(type="string")
	private String cname;
	@Type(type="long")
	private long mobileNo;
	@Column(length=40)
	@Type(type="string")
	private  String callerTune;
	@Type(type="int")
	@Version
	private  Integer versionCount;
	
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getCallerTune() {
		return callerTune;
	}
	public void setCallerTune(String callerTune) {
		this.callerTune = callerTune;
	}
	public Integer getVersionCount() {
		return versionCount;
	}
	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}
	@Override
	public String toString() {
		return "MobileCustomer [cno=" + cno + ", cname=" + cname + ", mobileNo=" + mobileNo + ", callerTune=" + callerTune
				+ ", versionCount=" + versionCount + "]";
	}
	
	

}
