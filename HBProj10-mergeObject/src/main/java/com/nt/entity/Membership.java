package com.nt.entity;

import java.io.Serializable;

public class Membership implements Serializable {
	private Long mid;
	private String  name;
	private  String addrs;
	private  Long rewardPoints;
	
	public Membership() {
		System.out.println("Membership:: 0-param constructor");
	}
	
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public Long getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(Long rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	
	@Override
	public String toString() {
		return "Membership [mid=" + mid + ", name=" + name + ", addrs=" + addrs + ", rewardPoints=" + rewardPoints
				+ "]";
	}
	
	
	

}
