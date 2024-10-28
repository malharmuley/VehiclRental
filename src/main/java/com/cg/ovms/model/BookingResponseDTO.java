package com.cg.ovms.model;

import java.time.OffsetDateTime;

public class BookingResponseDTO {
	private int bookingId;
	private OffsetDateTime bookingDate;
	private OffsetDateTime bookingFromDate;
	private OffsetDateTime bookingTillDate;
	private String bookingDescription;
	private String bookingStatus;
	private double totalCost;
	private double distance;
	private String payment;
	private BookingUserDTO userInfo;
	private BookingVehicleDTO vehicleInfo;
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public OffsetDateTime getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(OffsetDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}
	public OffsetDateTime getBookingFromDate() {
		return bookingFromDate;
	}
	public void setBookingFromDate(OffsetDateTime bookingFromDate) {
		this.bookingFromDate = bookingFromDate;
	}
	public OffsetDateTime getBookingTillDate() {
		return bookingTillDate;
	}
	public void setBookingTillDate(OffsetDateTime bookingTillDate) {
		this.bookingTillDate = bookingTillDate;
	}
	public String getBookingDescription() {
		return bookingDescription;
	}
	public void setBookingDescription(String bookingDescription) {
		this.bookingDescription = bookingDescription;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public BookingUserDTO getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(BookingUserDTO userInfo) {
		this.userInfo = userInfo;
	}
	public BookingVehicleDTO getVehicleInfo() {
		return vehicleInfo;
	}
	public void setVehicleInfo(BookingVehicleDTO vehicleInfo) {
		this.vehicleInfo = vehicleInfo;
	}
	
}
