package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@Table(name="CARMODEL_MAP")
public class CarModel {
	@Id
	@Type(type="long")
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "gen1",sequenceName = "car_model_seq",initialValue = 101,allocationSize = 1)
	private  Long modelId;
	
	@Type(type="string")
	@Column(length = 20)
	@NonNull
	private String modelName;
	
	@Type(type="string")
	@Column(length = 20)
	@NonNull
	private String type;
	
	@Type(type="string")
	@Column(length = 10)
	@NonNull
	private String fuelType;
	
	public CarModel() {
		System.out.println("CarModel:: 0-param consturctor");
	}

	@Override
	public String toString() {
		return "CarModel [modelId=" + modelId + ", modelName=" + modelName + ", type=" + type + ", fuelType=" + fuelType
				+ "]";
	}

}
