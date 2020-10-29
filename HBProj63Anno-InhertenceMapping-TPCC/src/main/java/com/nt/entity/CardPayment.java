package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Data
@Table(name="CARDPAYMENT_TPCC")
public class CardPayment extends Payment {
	@Type(type="long")
	private Long cardNo;
	@Column(length = 10)
	@Type(type="string")
	private String cardType;
	@Column(length = 10)
	@Type(type="string")
		private  String  paymentGateway;
	@Override
	public String toString() {
		return "CardPayment [cardNo=" + cardNo + ", cardType=" + cardType + ", paymentGateway=" + paymentGateway
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
