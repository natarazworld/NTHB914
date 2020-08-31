package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
@Entity
@Table(name="PROGRAMMER_PROJECT_INFO")
public class ProgrammerProjectInfo  implements Serializable {
	@EmbeddedId
	private  PrgmrProjId  id;
	@Column(name="PNAME",length = 20)
	@Type(type="string")
	private String pname;
	@Column(name="PROJNAME",length = 20)
	@Type(type="string")
	private String projName;
	@Column(name="DEPTNO")
	@Type(type="int")
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
