package com.cisc181.core;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cisc181.eNums.eMajor;
import com.cisc181.eNums.eTitle;

public class Student_Test {
	
	private static ArrayList<Enrollment> erollList = new ArrayList<Enrollment>();
	private static ArrayList<Course> courseList = new ArrayList<Course>();
	private static ArrayList<Semester> semesterList = new ArrayList<Semester>();
	private static ArrayList<Section> sectionList = new ArrayList<Section>();
	private static ArrayList<Student> studentList = new ArrayList<Student>();

	@BeforeClass
	public static void setup() throws PersonException {
		
		final UUID FALL = UUID.randomUUID();
		final UUID SPRING = UUID.randomUUID();
		semesterList.add(new Semester(FALL, new Date(2018, 2, 5), new Date(2018, 5, 24)));
		semesterList.add(new Semester(SPRING, new Date(2017, 8, 29), new Date(2017, 12, 16)));
		
		final UUID Chem104 = UUID.randomUUID();	
		final UUID Accounting101 = UUID.randomUUID();
		final UUID Phy208 = UUID.randomUUID();
		courseList.add(new Course(Chem104, "Chemistry 104", 4, eMajor.CHEM));
		Course course2 = new Course(Accounting101, "Accounting 101", 4, eMajor.BUSINESS);
		Course course3 = new Course(Phy208, "Physics 208", 4, eMajor.PHYSICS);
		
		int r = 20;
		for(Semester se: semesterList)
		{
			for(Course co: courseList)
			{
				sectionList.add(new Section(co.getCourseID(), se.getSemesterID(), UUID.randomUUID(), r));
				r += 10;
			}
		}
		
		studentList.add(new Student("Bobby", "John", "Ray", new Date(1995, 3, 3), eMajor.CHEM, "46 Wallaby Way", "(302)-567-0000", "Bobby.ray@gmail.com"));
		studentList.add(new Student("Harold", "John", "Ray", new Date(1994, 3, 3), eMajor.BUSINESS, "46 Wallaby Way", "(302)-567-0000", "Harold.ray@gmail.com"));
		studentList.add(new Student("Joe", "John", "Ray", new Date(1995, 5, 3), eMajor.CHEM, "46 Wallaby Way", "(302)-567-0000", "Joe.ray@gmail.com"));
		studentList.add(new Student("Maria", "Nicole", "Ray", new Date(1995, 6, 8), eMajor.CHEM, "46 Wallaby Way", "(302)-567-0000", "Maria.ray@gmail.com"));
		studentList.add(new Student("Charlie", "John", "Ray", new Date(1979, 11, 8), eMajor.CHEM, "46 Wallaby Way", "(302)-567-0000", "Charlie.ray@gmail.com"));
		studentList.add(new Student("Katie", "Emily", "Ray", new Date(1987, 3, 15), eMajor.COMPSI, "46 Wallaby Way", "(302)-567-0000", "Katie.ray@gmail.com"));
		studentList.add(new Student("Amanda", "Elizabeth", "Ray", new Date(1995, 3, 3), eMajor.NURSING, "46 Wallaby Way", "(302)-567-0000", "Amanda.ray@gmail.com"));
		studentList.add(new Student("Ben", "John", "Ray", new Date(1980, 10, 3), eMajor.NURSING, "46 Wallaby Way", "(302)-567-0000", "Ben.ray@gmail.com"));
		studentList.add(new Student("Sam", "John", "Ray", new Date(1982, 9, 13), eMajor.PHYSICS, "46 Wallaby Way", "(302)-567-0000", "Sam.ray@gmail.com"));
		studentList.add(new Student("Matt", "John", "Ray", new Date(1988, 3, 3), eMajor.CHEM, "46 Wallaby Way", "(302)-567-0000", "Matt.ray@gmail.com"));
	
		for(Section sn: sectionList)
		{
			for(Student st: studentList)
			{
				erollList.add(new Enrollment(sn.getSectionID(), st.getStudentID()));

				for(Enrollment en: erollList)
				{
					en.SetGrade(99.00);
				}
			}
		}
	}

	@Test
	public void test() {
		
		double credTotal = 0;
		double credGot = 0;
		double stuNumber = 0;
		double gradeTotal = 0;
		
		for(Enrollment e: erollList)
		{
			for(Course c: courseList)
			{
				credTotal += c.getGradePoints();
				credGot += e.getGrade() * c.getGradePoints();
			}
			
			gradeTotal += e.getGrade();
			stuNumber += 1;
		}
	
		assertEquals((credGot/credTotal), 99.00, 0.01);
		assertEquals((gradeTotal/stuNumber), 99.00, 0.01);
	}
}