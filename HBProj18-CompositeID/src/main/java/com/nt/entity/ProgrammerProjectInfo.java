package com.nt.entity;

import java.io.Serializable;

public class ProgrammerProjectInfo  implements Serializable {
	private  PrgmrProjId  id;
	private String pname;
	private String projName;
	private Integer deptNo;
	public PrgmrProjId getId() {
		return id;
	}
	public void setId(PrgmrProjId id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	
	@Override
	public String toString() {
		return "ProgrammerProjectInfo [id=" + id + ", pname=" + pname + ", projName=" + projName + ", deptNo=" + deptNo
				+ "]";
	}
	
	

}
