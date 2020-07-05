package com.javaMicroServices.os.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="ORDER_TB")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	@Id
	private int id;
	private String name;
	private int quantity;
	private double price;
	

}
