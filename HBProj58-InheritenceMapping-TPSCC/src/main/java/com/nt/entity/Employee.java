package com.nt.entity;

import lombok.Data;

@Data
public class Employee extends Person {
	private String desg;
	private Float salary;
	private Integer deptNo;
	@Override
	public String toString() {
		return super.toString() +"Employee [desg=" + desg + ", salary=" + salary + ", deptNo=" + deptNo + ", toString()="
				+  "]";
	}
	
	

}
