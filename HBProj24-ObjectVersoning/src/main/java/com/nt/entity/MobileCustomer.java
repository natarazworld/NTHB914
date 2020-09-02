package com.nt.entity;

import java.io.Serializable;

public class MobileCustomer  implements Serializable {
	private  Integer cno;
	private String cname;
	private long mobileNo;
	private  String callerTune;
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
