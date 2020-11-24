package com.nt.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Person implements Serializable{
  private Integer pid;
  @NonNull
  private String pname;
  @NonNull
  private String addrs;
  public Person() {
	System.out.println("Person.0-param constructor");
}
@Override
public String toString() {
	return "Person [pid=" + pid + ", pname=" + pname + ", addrs=" + addrs + "]";
}
  
  


}
