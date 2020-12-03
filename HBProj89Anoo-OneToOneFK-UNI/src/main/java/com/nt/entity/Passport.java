//Passport.java (child class)
package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name="PASSPORT_ANNO_OTO")
public class Passport implements Serializable {
	@Id
	@Type(type="long")
	@SequenceGenerator(name = "gen1",sequenceName = "PSPT_NO_SEQ",initialValue = 10000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Long psptNo;
	
	@NonNull
	@Type(type="string")
	@Column(length=20)
	private String country;
	
	@NonNull
	private LocalDate expiryDate;
	@OneToOne(targetEntity = Person.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
	@JoinColumn(name="PERSON_ID",referencedColumnName = "PID")
	private  Person  personDetails;
	
	public Passport() {
		System.out.println("Passport: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Passport [psptNo=" + psptNo + ", country=" + country + ", expirtyDate=" + expiryDate + "]";
	}
	
	

}
