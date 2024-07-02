package com.reserve.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Rooms")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	private Long rid;
	
	@Column(name="room_number")
	private Integer rNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "room_type")
	
	private RoomType rType;
	
	private Double price;
	
	private String availability;

	public Room(Integer rNumber, RoomType rType, Double price, String availability) {
		super();
		this.rNumber = rNumber;
		this.rType = rType;
		this.price = price;
		this.availability = availability;
	}

	

	

	 
		

}
