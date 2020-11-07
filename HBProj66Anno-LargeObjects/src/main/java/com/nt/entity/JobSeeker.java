package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Data
public class JobSeeker implements Serializable {
	@Id
	@GeneratedValue
	@Type(type="int")
	private Integer jsId;
	
	@Column(length=10)
	@Type(type="string")
	private String jsName;
	
	@Column(length=10)
	@Type(type="string")
	private String jsAddrs;
	
	
	//LOB property
	//@Type(type="binary")
	@Lob
	private  byte[] photo;
	
	
	//LOB property 
	//@Type(type="character")
	@Lob
	private  char[] resume;
	
	@Type(type="boolean")
	private  boolean active;
	
	


}
