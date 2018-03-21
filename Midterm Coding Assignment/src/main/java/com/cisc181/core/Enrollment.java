
package com.cisc181.core;
import java.util.UUID;
public class Enrollment 
{
	private UUID SectonID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double Grade;
	private Enrollment()
	{
	}
	public Enrollment(UUID StudentID, UUID SectionID)
	{
		this.StudentID = StudentID;
		this.SectonID = SectionID;
		EnrollmentID = UUID.randomUUID();
	}
	public void SetGrade(double grade)
	{
		this.Grade = grade;
	}
	public double getGrade() 
	{
		return Grade;
	}
	public UUID getSectonID() 
	{
		return SectonID;
	}
	public void setSectonID(UUID sectonID) 
	{
		this.SectonID = sectonID;
	}
	public UUID getStudentID() 
	{
		return StudentID;
	}
	public void setStudentID(UUID studentID) 
	{
		this.StudentID = studentID;
	}
	public UUID getEnrollmentID() 
	{
		return EnrollmentID;
	}
	public void setEnrollmentID(UUID enrollmentID) 
	{
		this.EnrollmentID = enrollmentID;
	}
}