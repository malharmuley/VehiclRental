package com.cg.ovms.model;

public class BookingVehicleDTO {
	private int vehicleId;
	private String vehicleNumber;
	private String type;
	private String category;
	private String description;
	private Integer capacity;
	private double chargesPerDay;
	
	public BookingVehicleDTO() {}
	
	public BookingVehicleDTO(int vehicleId, String vehicleNumber, String type, String category, String description,
			Integer capacity, double chargesPerDay) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.category = category;
		this.description = description;
		this.capacity = capacity;
		this.chargesPerDay = chargesPerDay;
	}
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public double getChargesPerDay() {
		return chargesPerDay;
	}
	public void setChargesPerDay(double chargesPerDay) {
		this.chargesPerDay = chargesPerDay;
	}
}
