package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import org.hibernate.annotations.Type;

@Embeddable
public class PrgmrProjId implements Serializable {
	@Type(type="int")
	//@Column(name="PID")
	private Integer pid;
	@Type(type="int")
	//@Column(name="PROJID")
	private Integer projId;
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getProjId() {
		return projId;
	}
	public void setProjId(Integer projId) {
		this.projId = projId;
	}
	
	@Override
	public String toString() {
		return "PrgmrProjId [pid=" + pid + ", projId=" + projId + "]";
	}
	
	

}
