//Entity class/ Domain class/model class/Persistent class/POJO class/HLO(hibernate language object) class
package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
public class Product implements Serializable {
	 //bean properties
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	
	/*	@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
	*/
	
	/*@Id
	@SequenceGenerator(name ="gen1",
	                                              sequenceName = "JPA_PID_SEQ",
	                                              initialValue = 1000,
	                                              allocationSize =10 )
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)*/
	
	
	/*@Id
	@SequenceGenerator(name ="gen1",
	                                              sequenceName = "JPA_PID_SEQ1") 
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	*/
	
	@Id
	@SequenceGenerator(name ="gen1",
	                                              sequenceName = "PID_SEQ",
	                                              initialValue = 500,
	                                              allocationSize = 5) 
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	
	private Integer pid;
	private String pname;
	private Float price;
	private Float qty;
	//setters and getters
	 //alt+shift+s ,r
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getQty() {
		return qty;
	}
	public void setQty(Float qty) {
		this.qty = qty;
	}
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", qty=" + qty + "]";
	}
	
	

}
