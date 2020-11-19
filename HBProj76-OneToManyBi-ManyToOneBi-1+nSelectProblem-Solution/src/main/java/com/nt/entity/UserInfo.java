package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@Data
@Setter
@Getter
//@NoArgsConstructor
@RequiredArgsConstructor

public class UserInfo implements Serializable {
	private int userId;
	@NonNull
	private String username;
	@NonNull
	private  String  addrs;
	private Set<PhoneNumber> phones;  // special property to build 1..* assocication (By holding muliple objects of child class)
	
	public UserInfo() {
		System.out.println("UserInfo:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", username=" + username + ", addrs=" + addrs + "]";
	}
	
	

}
