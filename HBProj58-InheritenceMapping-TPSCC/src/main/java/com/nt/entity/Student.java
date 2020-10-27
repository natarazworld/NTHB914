package com.nt.entity;

import lombok.Data;

@Data
public class Student extends Person {
    private String college;
    private String branch;
    private  Float avg;
	@Override
	
	public String toString() {
		return super.toString() +"Student [college=" + college + ", branch=" + branch + ", avg=" + avg + ", toString()="
				+  "]";
	}
    
    
}
