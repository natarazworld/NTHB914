package com.nt.entity;

import java.io.Serializable;

public class Project implements Serializable{
	private long projId;
	private String projName;
	private int teamsize;
	
	public long getProjId() {
		return projId;
	}
	public void setProjId(long projId) {
		this.projId = projId;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public int getTeamsize() {
		return teamsize;
	}
	public void setTeamsize(int teamsize) {
		this.teamsize = teamsize;
	}
	@Override
	public String toString() {
		return "Project [projId=" + projId + ", projName=" + projName + ", teamsize=" + teamsize + "]";
	}

}
