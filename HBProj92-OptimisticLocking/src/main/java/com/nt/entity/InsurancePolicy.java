package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Data;






@Entity
@Data
public class InsurancePolicy implements Serializable {
	@Id
	private Long policyId;
	private String policyName;
	private String policyType;
	private String company;
	private Integer tenure;
	@Version
	private Integer updateCount; 

}
