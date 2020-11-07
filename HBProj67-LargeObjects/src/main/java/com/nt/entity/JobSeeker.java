package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
public class JobSeeker implements Serializable {
	private Integer jsId;
	private String jsName;
	private String jsAddrs;
	private  byte[] photo;
	private  char[] resume;
	/*private  boolean active;*/


}
