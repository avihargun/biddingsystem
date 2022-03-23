package com.project.bidding.api.entity;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class bid {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bidno;
	private long eventNo;
	private long categoryNo;
	private LocalTime bidTime;
	private String bidderEmail;
	private int bidValue;
	
	
	public bid() {
		super();
	}


	public bid(int bidno, long eventNo, long categoryNo, LocalTime bidTime, String bidderEmail, int bidValue) {
		super();
		this.bidno = bidno;
		this.eventNo = eventNo;
		this.categoryNo = categoryNo;
		this.bidTime = bidTime;
		this.bidderEmail = bidderEmail;
		this.bidValue = bidValue;
	}


	public int getBidno() {
		return bidno;
	}


	public void setBidno(int bidno) {
		this.bidno = bidno;
	}


	public long getEventNo() {
		return eventNo;
	}


	public void setEventNo(long eventNo) {
		this.eventNo = eventNo;
	}


	public long getCategoryNo() {
		return categoryNo;
	}


	public void setCategoryNo(long categoryNo) {
		this.categoryNo = categoryNo;
	}


	public LocalTime getBidTime() {
		return bidTime;
	}


	public void setBidTime(LocalTime bidTime) {
		this.bidTime = bidTime;
	}


	public String getBidderEmail() {
		return bidderEmail;
	}


	public void setBidderEmail(String bidderEmail) {
		this.bidderEmail = bidderEmail;
	}


	public int getBidValue() {
		return bidValue;
	}


	public void setBidValue(int bidValue) {
		this.bidValue = bidValue;
	}

	
	

	

}
