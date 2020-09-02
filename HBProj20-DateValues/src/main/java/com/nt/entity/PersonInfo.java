package com.nt.entity;

import java.io.Serializable;
import java.util.Date;

public class PersonInfo implements Serializable {
	private int pid;
	private String pname;
	private String paddrs;
	private  Date  dob;
	private Date  dom;
	private Date doj;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPaddrs() {
		return paddrs;
	}
	public void setPaddrs(String paddrs) {
		this.paddrs = paddrs;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDom() {
		return dom;
	}
	public void setDom(Date dom) {
		this.dom = dom;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
	@Override
	public String toString() {
		return "PersonInfo [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + ", dob=" + dob + ", dom=" + dom
				+ ", doj=" + doj + "]";
	}
	
	
	
	

}
