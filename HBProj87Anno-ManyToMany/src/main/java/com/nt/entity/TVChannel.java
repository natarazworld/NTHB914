package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TVCHANNEL_MTOM")
@Setter
@Getter
@RequiredArgsConstructor
public class TVChannel implements Serializable{
	@Id
	@GeneratedValue
	@Type(type="int")
	private Integer channelId;
	
	@Type(type="string")
	@Column(length=15)
	@NonNull
	private String channelName;
	
	@Type(type="string")
	@Column(length=25)
	@NonNull
	private  String  company;
	
	@Type(type="string")
	@Column(length=25)
	@NonNull
	private  String  location;
	
	@ManyToMany(targetEntity = Subscriber.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="channels")
	private Set<Subscriber> subscribers;
	
	 public TVChannel() {
		System.out.println("TVChannel:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "TVChannel [channelId=" + channelId + ", channelName=" + channelName + ", company=" + company
				+ ", location=" + location + "]";
	}
	 
	 
	

}
