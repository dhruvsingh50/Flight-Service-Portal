package com.wipro.frs.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FRS_TBL_FLIGHT")
public class FlightBean {
	
	@Override
	public String toString() {
		return "FlightBean [flightID=" + flightID + ", flightName="
				+ flightName + ", seatingCapacity=" + seatingCapacity
				+ ", reservationCapacity=" + reservationCapacity + "]";
	}
	@Id
	@Column
	String flightID;
	@Column
	String flightName;
	@Column
	int seatingCapacity;
	@Column
	int reservationCapacity;
	
	
	public String getFlightID() {
		return flightID;
	}
	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public int getReservationCapacity() {
		return reservationCapacity;
	}
	public void setReservationCapacity(int reservationCapacity) {
		this.reservationCapacity = reservationCapacity;
	}
	
	

}
