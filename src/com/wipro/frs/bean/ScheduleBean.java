package com.wipro.frs.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FRS_TBL_SCHEDULE")
public class ScheduleBean {
	
	@Id
	@Column
	String scheduleID;
	@Column
	String flightID;
	@Column
	String routeID;
	@Column
	int travelDuration;
	@Column
    String availableDays;
	@Column
	String departureTime;
	
	
	public String getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(String scheduleID) {
		this.scheduleID = scheduleID;
	}
	public String getFlightID() {
		return flightID;
	}
	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}
	public String getRouteID() {
		return routeID;
	}
	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}
	public int getTravelDuration() {
		return travelDuration;
	}
	public void setTravelDuration(int travelDuration) {
		this.travelDuration = travelDuration;
	}
	public String getAvailableDays() {
		return availableDays;
	}
	public void setAvailableDays(String availableDays) {
		this.availableDays = availableDays;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	
	@Override
	public String toString() {
		return "ScheduleBean [scheduleID=" + scheduleID + ", flightID="
				+ flightID + ", routeID=" + routeID + ", travelDuration="
				+ travelDuration + ", availableDays=" + availableDays
				+ ", departureTime=" + departureTime + "]";
	}
	

}
