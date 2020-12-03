//Canteen.java (child class)
package com.nt.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="CANTEEN_ANNO_OTO")
@Getter
@Setter
@RequiredArgsConstructor
public class CanteenCard implements Serializable {
	@Id
	@GenericGenerator(name ="gen1",strategy = "foreign",
	                                     parameters = @Parameter(name="property" ,value ="empDetails" ) )
	@GeneratedValue(generator="gen1")
	@Type(type="int")
	private  Integer cardid;
	
	@Column(length=15)
	@Type(type="string")
	@NonNull
	private String canteenName;

	@Column(length=15)
	@Type(type="string")
	@NonNull
	private  String location;
	
	@Column(length=15)
	@Type(type="string")
	@NonNull
	private  String cardType;
	@OneToOne(targetEntity = Employee.class,cascade = CascadeType.ALL,
			                                        fetch = FetchType.LAZY,orphanRemoval = true,mappedBy = "cardDetails")
	private  Employee  empDetails;
	
	public CanteenCard() {
		System.out.println("CanteenCard:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "CanteenCard [cardid=" + cardid + ", canteenName=" + canteenName + ", location=" + location
				+ ", cardType=" + cardType + "]";
	}
	
	

}
