//PoliticalLeader(child class)
package com.nt.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class PoliticalLeader  implements Serializable {
	@Id
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="gen1",sequenceName = "AADHAR_SEQ",initialValue = 1000,allocationSize = 1)
	
	private  long leaderAadharNo;
	@Column(length = 20)
	@Type(type="string")
	@NonNull
	private String leaderName;
	
	@Column(length = 15)
	@Type(type="string")
	@NonNull
	private String leaderPosition;
	
	@Column(length = 15)
	@Type(type="string")
	@NonNull
	private String leaderLocation;
	
	@ManyToOne(targetEntity = PoliticalParty.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "PARTY_ID",referencedColumnName = "PARTYID")
	//@LazyToOne(LazyToOneOption.PROXY)  //HB style fetch type
	private PoliticalParty  party;
	
	public PoliticalLeader() {
		System.out.println("PoliticalLeader:: 0-param constructor");
	}

	
	@Override
	public String toString() {
		return "PoliticalLeader [leaderAadharNo=" + leaderAadharNo + ", leaderName=" + leaderName + ", leaderPosition="
				+ leaderPosition + ", leaderLocation=" + leaderLocation + "]";
	}
	
	

}
