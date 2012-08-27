package com.tangotab.TO;

import java.util.Date;

public class WeekDate
{
  private Date date;
  private int dateOfDate;
  private String dayName;
  private String dayLetter;
  private String availableDates;

  public Date getDate()
  {
    return this.date;
  }
  public void setDate(Date date) {
    this.date = date;
  }
  public int getDateOfDate() {
    return this.dateOfDate;
  }
  public void setDateOfDate(int dateOfDate) {
    this.dateOfDate = dateOfDate;
  }

  public String getDayName() {
    return this.dayName;
  }
  public void setDayName(String dayName) {
    this.dayName = dayName;
  }
  public String getDayLetter() {
    return this.dayLetter;
  }
  public void setDayLetter(String dayLetter) {
    this.dayLetter = dayLetter;
  }
  public void setAvailableDates(String availableDates) {
    this.availableDates = availableDates;
  }
  public String getAvailableDates() {
    return this.availableDates;
  }
}