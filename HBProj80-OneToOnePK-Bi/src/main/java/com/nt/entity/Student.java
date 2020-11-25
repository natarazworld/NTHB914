package com.nt.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Student implements Serializable {
	private  Integer sid;
	@NonNull
	private  String sname;
	@NonNull
	private  String  sadd;
	private LibraryMembership libraryDetails;
	
	public Student() {
	  System.out.println("Student:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sadd=" + sadd + "]";
	}

}
