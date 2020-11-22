package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Doctor implements Serializable {
	private Integer did;
	@NonNull
	private String name;
	@NonNull
	private String hospital;
	@NonNull
	private String qualification;
	
	private  Set<Patient> patients;
	
	public Doctor() {
		System.out.println("Doctor:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Doctor [did=" + did + ", name=" + name + ", hospital=" + hospital + ", qualification=" + qualification
				+ "]";
	}
	
	

}
