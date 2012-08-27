package com.tangotab.TO;

import java.io.Serializable;
import java.util.Date;

public class EventsTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer eventId;
	private String eventName;
	private Date startDate;
	private Date endDate;
	private String eventCode;
	private Short isActive;
	
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getEventCode() {
		return eventCode;
	}
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	public Short getIsActive() {
		return isActive;
	}
	public void setIsActive(Short isActive) {
		this.isActive = isActive;
	}
	
	
}
