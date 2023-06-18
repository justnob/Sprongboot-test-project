package com.amarnath.example.myapi.application;

public class LaptopsDetails {
	
	private Long id;
	private String name;
	private String manufature;
	
	public LaptopsDetails(Long id, String name, String manufature) {
		super();
		this.id = id;
		this.name = name;
		this.manufature = manufature;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufature() {
		return manufature;
	}

	public void setManufature(String manufature) {
		this.manufature = manufature;
	}

	@Override
	public String toString() {
		return "LaptopsDetails [id=" + id + ", Name=" + name + ", manufature=" + manufature + "]";
	}
	
	

}
