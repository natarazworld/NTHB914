package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Patient implements Serializable {
	private Integer pid;
	@NonNull
	private String name;
	@NonNull
	private String problem;
	private Set<Doctor> doctors;
	
	public Patient() {
		System.out.println("Patient:: 0-param construtor");
	}

	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", name=" + name + ", problem=" + problem ;
	}
	
	
	
	

}
