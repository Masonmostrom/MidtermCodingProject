package com.cisc181.core;

import java.util.UUID;
import java.util.Calendar;
import java.util.Date;
public class Semester 
{
	private UUID SemesterID;
	private Date StartDate;
	private Date EndDate;
	public Semester()
	{
	}
	public Semester(UUID semesterID, Date startDate, Date endDate) 
	{
		this.SemesterID = semesterID;
		this.StartDate = startDate;
		this.EndDate = endDate;
	}
	public UUID getSemesterID() 
	{
		return SemesterID;
	}
	public void setSemesterID(UUID semesterID) 
	{
		this.SemesterID = semesterID;
	}
	public Date getStartDate() 
	{
		return StartDate;
	}
	public void setStartDate(Date startDate) 
	{
		this.StartDate = startDate;
	}
	public Date getEndDate() 
	{
		return EndDate;
	}
	public void setEndDate(Date endDate) 
	{
		this.EndDate = endDate;
	}
}