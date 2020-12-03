package com.nt.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="SUBSCRIBER_MTOM_IDBAG")
@Setter
@Getter
@RequiredArgsConstructor
public class Subscriber  implements Serializable {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "sub_id_seq",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer subscriberId;
	@Column(length=20)
	@Type(type="string")
	@NonNull
	private String  subscriberName;
	@Column(length=20)
	@Type(type="string")
	@NonNull
	private String  subscriberType;
	@Column(length=20)
	@Type(type="string")
	@NonNull
	private String  subscriberLocation;
	@ManyToMany(targetEntity = TVChannel.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="CHANNEL_SUBSCRIBER_IDBAG",
	                     joinColumns = @JoinColumn(name ="SUBSCRIBER_ID",referencedColumnName = "SUBSCRIBERID" ),  //owning side fk col
	                     inverseJoinColumns = @JoinColumn(name ="CHANNEL_ID",referencedColumnName = "CHANNELID" )  // non-owning side fk  col
	                    )
	@GenericGenerator(name = "gen1",strategy = "increment")
	@CollectionId(columns = @Column(name="ch_sub_id"),
	                                             type =@Type(type="int") ,
	                                             generator = "gen1")
	private List<TVChannel> channels;
	
	public Subscriber() {
		System.out.println("Subscriber:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Subscriber [subscriberId=" + subscriberId + ", subscriberName=" + subscriberName + ", subscriberType="
				+ subscriberType + ", subscriberLocation=" + subscriberLocation + "]";
	}
	
	
	
	

}
