package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LibraryMembership implements Serializable {
	private Integer lid;
	@NonNull
	private String type;
	@NonNull
	private  LocalDate  startDate;
	@NonNull
	private  LocalDate endDate;
	private Student studentDetails;
	
	public LibraryMembership() {
		System.out.println("LibraryMembership:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "LibraryMembership [lid=" + lid + ", type=" + type + ", startDate=" + startDate + ", endDate=" + endDate
				+ "]";
	}
	
	
	

}
