package com.nt.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;
import org.hibernate.annotations.Type;

import lombok.Data;
@Data
public class Employee implements Serializable {
	private Integer eno;
	private String ename;
	private String eadd;
	 
	  private  List<String> friendsList;
	  private List<String> relativesList;
	 private Set<Long>phones;
	  private  Map<String,Long> bankAccounts;
}
