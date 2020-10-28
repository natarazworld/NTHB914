package com.nt.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@DiscriminatorValue("cheque")
public class ChequePayment extends Payment {
	@Type(type="long")
	private Long chequeNo;
	
	@Column(length = 10)
	@Type(type="string")
	private String chequeType;
	
	private  LocalDate  expiryDate;

	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + ", expiryDate=" + expiryDate
				+ ", toString()=" + super.toString() + "]";
	} 	
	
	

}
