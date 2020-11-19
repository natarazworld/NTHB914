package com.nt.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@Data
@Setter
@Getter
@RequiredArgsConstructor
public class PhoneNumber implements Serializable {
	private int regNo;
	@NonNull
	private long phone;
	@NonNull
	private String type;
	@NonNull
	private  String provider;
	private UserInfo user;
	
	public PhoneNumber() {
		System.out.println("PhoneNumber:: 0-param constrcutor");
	}

	@Override
	public String toString() {
		return "PhoneNumber [regNo=" + regNo + ", phone=" + phone + ", type=" + type + ", provider=" + provider + "]";
	}
	
	

}
