package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name ="hello")
public class Product {
	
	@javax.persistence.Id
	@GeneratedValue(generator = "seq_genrater",strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="seq_genrater",initialValue = 01,allocationSize = 1)
	private int pid;
	
	@Column(length = 25,nullable = false)
	private String name;
	
	@Column(length = 25,nullable = false)
	private String brand;
	
	@Column(nullable = false)
	private int price;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
