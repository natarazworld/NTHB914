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

@Entity
@Table(name="EMPLOYEE_COLLECTION")
@Data
public class Employee implements Serializable {
	@Id
	@GeneratedValue
	@Type(type="int")
	private Integer eno;
	
	@Type(type="string")
	@Column(length=15)
	private String ename;
	
	@Type(type="string")
	@Column(length=15)
	private String eadd;
	
	 @ElementCollection
	 @Column(name="FRIEND")
	 @CollectionTable(name = "EMP_FRIENDS",
	                                     joinColumns = @JoinColumn(name="emp_id",referencedColumnName = "eno"))
	 @OrderColumn(name = "FRIEND_NO")
	 @ListIndexBase(value = 1)
	 
	  private  List<String> friendsList;
	 
	 @ElementCollection
	 @Column(name="MOBILENUMBER")
	 @CollectionTable(name="EMP_PHONES",
	                                      joinColumns=@JoinColumn(name="emp_id",referencedColumnName = "eno")) 
	 private Set<Long>phones;
	
     @ElementCollection
     @Column(name="BANK_ACCOUNT")
     @CollectionTable(name="EMP_ACCOUNTS",
    		                            joinColumns=@JoinColumn(name="emp_id",referencedColumnName = "eno"))
     @MapKeyColumn(name = "BANK_NAME",length = 10)
     
	  private  Map<String,Long> bankAccounts;
}
