package com.wipro.frs.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="FRS_TBL_RESERVATION")
public class ReservationBean {
	
	@Id
	@Column
	String reservationID;
	@Column
	String userID;
	@Column
	String scheduleID;
	@Column
	String reservationType;
	@Column
	Date bookingDate;
	@Column
	Date journeyDate;
	@Column
	int noOfSeats;
	@Column
	double totalFare;
	@Column
	int bookingStatus;
	
	
	@Override
	public String toString() {
		return "ReservationBean [reservationID=" + reservationID + ", userID="
				+ userID + ", scheduleID=" + scheduleID + ", reservationType="
				+ reservationType + ", bookingDate=" + bookingDate
				+ ", journeyDate=" + journeyDate + ", noOfSeats=" + noOfSeats
				+ ", totalFare=" + totalFare + ", bookingStatus="
				+ bookingStatus + "]";
	}
	public String getReservationID() {
		return reservationID;
	}
	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(String scheduleID) {
		this.scheduleID = scheduleID;
	}
	public String getReservationType() {
		return reservationType;
	}
	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
	public int getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(int bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
	

}
