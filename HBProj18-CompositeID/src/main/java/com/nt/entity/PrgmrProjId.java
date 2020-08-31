package com.nt.entity;

import java.io.Serializable;

public class PrgmrProjId implements Serializable {
	private Integer pid;
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
