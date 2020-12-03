//Person.java (parent class)
package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name="PERSON_ANNO_OTO")
public class Person implements Serializable{
	@Id
	@Type(type="int")
	@GeneratedValue
  private Integer pid;
  @NonNull
  @Column(length=15)
  @Type(type="string")
  private String pname;
  
  @NonNull
  @Column(length=15)
  @Type(type="string")
  private String addrs;

  public Person() {
	System.out.println("Person.0-param constructor");
}
@Override
public String toString() {
	return "Person [pid=" + pid + ", pname=" + pname + ", addrs=" + addrs + "]";
}

}
