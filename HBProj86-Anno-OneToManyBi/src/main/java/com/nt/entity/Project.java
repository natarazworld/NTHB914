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

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="PROJECT_OTM_BI")
@RequiredArgsConstructor
@Getter
@Setter
public class Project  implements  Serializable {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "PROJ_ID_SEQ",allocationSize = 1,initialValue = 1000)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Type(type="long")
	private Long projId;
	
	@Column(length=20)
	@Type(type="string")
	@NonNull
	private String projName;
	
	@Column(length=20)
	@Type(type="string")
	@NonNull
	private String projType;
	
	@Type(type="int")
	@NonNull
	private Integer teamSize;
	@ManyToOne(targetEntity = Company.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_ID",referencedColumnName = "COMPID")
	private Company company;
	
	public Project() {
		System.out.println("Project:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Project [projId=" + projId + ", projName=" + projName + ", projType=" + projType + ", teamSize="
				+ teamSize + "]";
	}
	
	

}
