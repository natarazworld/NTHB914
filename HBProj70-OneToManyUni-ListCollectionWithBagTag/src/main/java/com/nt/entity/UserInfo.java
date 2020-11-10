package com.nt.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
//@NoArgsConstructor
@RequiredArgsConstructor
public class UserInfo implements Serializable {
	private int userId;
	@NonNull
	private String username;
	@NonNull
	private  String  addrs;
	private List<PhoneNumber> phones;  // special property to build 1..* assocication (By holding muliple objects of child class)
	
	public UserInfo() {
		System.out.println("UserInfo:: 0-param constructor-->"+this.hashCode());
	}

}
