package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import com.cisc181.core.*;
import com.cisc181.eNums.eTitle;

public class Staff_Test {

	private static ArrayList<Staff> sList = new ArrayList<Staff>();
	@BeforeClass
	public static void setup() throws PersonException{
		
		sList.add(new Staff("Elroy","John","Son",new Date(1979, 1, 1),"46 Wallaby Way","(302)-123-4567","Elroy.son@gmail.com",
				"Monday 6-9",9,100000.00,new Date(1999, 1, 1),eTitle.MR));
		sList.add(new Staff("Joe","John","Son",new Date(1979, 1, 1),"46 Wallaby Way","(302)-123-4567","Elroy.son@gmail.com",
				"Monday 6-9",9,110000.00,new Date(1999, 1, 1),eTitle.MR));
		sList.add(new Staff("Peter","John","Son",new Date(1979, 1, 1),"46 Wallaby Way","(302)-123-4567","Elroy.son@gmail.com",
				"Monday 6-9",9,120000.00,new Date(1999, 1, 1),eTitle.MR));
		sList.add(new Staff("Sean","John","Son",new Date(1979, 1, 1),"46 Wallaby Way","(302)-123-4567","Elroy.son@gmail.com",
				"Monday 6-9",9,130000.00,new Date(1999, 1, 1),eTitle.MR));
		sList.add(new Staff("Bill","John","Son",new Date(1979, 1, 1),"46 Wallaby Way","(302)-123-4567","Elroy.son@gmail.com",
				"Monday 6-9",9,140000.00,new Date(1999, 1, 1),eTitle.MR));
	}
	
	@Test
	public void test() 
	{
		
		double totalIncome = 0;
		for(Staff staff: sList)
		{
			totalIncome += staff.getSalary();
		}
		assertEquals((totalIncome/sList.size()), 120000.00, 0.01);
		boolean firstThrown = false;
		try
		{
			Staff JoeSon = new Staff("Joe","John","Son",new Date(1890, 2, 5),"46 Wallaby Way","(302)-123-4567","Elroy.son@gmail.com",
					"Monday 6-9",9,110000.00,new Date(1999, 1, 1),eTitle.MR);
		}
		catch(PersonException ex)
		{
			firstThrown = true;
		}
		assertTrue(firstThrown);
		boolean nextThrown = false;
		try
		{
			Staff PeterSon = new Staff("Peter","John","Son",new Date(1979, 1, 1),"46 Wallaby Way","(302)-123-s2us","Elroy.son@gmail.com",
					"Monday 6-9",9,120000.00,new Date(1999, 1, 1),eTitle.MR);
		}
		catch(PersonException ex)
		{
			nextThrown = true;
		}
		assertTrue(nextThrown);
	}	
}