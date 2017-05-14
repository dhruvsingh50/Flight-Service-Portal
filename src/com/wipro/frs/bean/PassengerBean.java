package com.wipro.frs.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FRS_TBL_PASSENGER")
public class PassengerBean {
	@Id
	int rid;
	@Column
	String reservationID;
	@Column
	String name;
	@Column
	String gender;
	@Column
	int age;
	@Column
	int seatNo;
	
	
	@Override
	public String toString() {
		return "PassengerBean [reservationID=" + reservationID + ", name="
				+ name + ", gender=" + gender + ", age=" + age + ", seatNo="
				+ seatNo + "]";
	}
	public String getReservationID() {
		return reservationID;
	}
	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	
	

}
