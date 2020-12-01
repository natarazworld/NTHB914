package com.nt.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.ListIndexBase;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Table(name="CARCOMPANY_LIST")
@Entity
@Setter
@Getter
@RequiredArgsConstructor
public class CarCompany  implements Serializable {
	@Id
	@Type(type="int")
	@GeneratedValue   //takes default sequence hibernate_sequence
	private Integer compId;
	
	@Column(length=15)
	@Type(type="string")
	@NonNull
	private String  compName;
	
	@Column(length=15)
	@Type(type="string")
	@NonNull
	private String  location;
	
	@LazyCollection(LazyCollectionOption.EXTRA)
	@OneToMany(targetEntity = CarModel.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true )
	@JoinColumn(name = "COMPANY_ID",referencedColumnName = "COMPID")
	 //@IndexColumn(name = "LST_INDX",base = 1)  HB specific .. Deprecated
	@OrderColumn(name = "LST_INDX")
	@ListIndexBase(value = 1)
    @Fetch(FetchMode.SELECT)
	private List<CarModel>  models;
	
	public CarCompany() {
		System.out.println("CarCompany:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "CarCompany [compId=" + compId + ", compName=" + compName + ", location=" + location + "]";
	}
}//class
