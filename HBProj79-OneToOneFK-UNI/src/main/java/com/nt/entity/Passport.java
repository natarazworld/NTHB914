package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Passport implements Serializable {
	private Long psptNo;
	@NonNull
	private String country;
	@NonNull
	private LocalDate expiryDate;
	private  Person  personDetails;
	
	public Passport() {
		System.out.println("Passport: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Passport [psptNo=" + psptNo + ", country=" + country + ", expirtyDate=" + expiryDate + "]";
	}
	
	

}
