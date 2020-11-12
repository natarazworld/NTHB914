package com.nt.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EmpDetails implements Serializable {
	private Integer eno;
	@NonNull
	private String ename;
	@NonNull
	private String eadd;
	@NonNull
	private Float salary;
	private Department dept;

}
