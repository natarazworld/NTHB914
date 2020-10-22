package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class StudentInfo implements Serializable {
	private int sno;
	private String sname;
	private  float avg;
	private Address addrs;

}
