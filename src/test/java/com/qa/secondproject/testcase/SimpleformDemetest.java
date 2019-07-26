package com.qa.secondproject.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.secondproject.qa.base.TestBase;
import com.qa.secondproject.qa.pages.*;
import com.qa.secondproject.util.*;

public class SimpleformDemetest extends TestBase {
	SimpleFormDemo Simplefor;
	String SheetName="number";
	SimpleformDemetest(){
		super();
	}
	@BeforeMethod	
	public void setup()
	{
	initialization();
	Simplefor= new SimpleFormDemo();
	
	}
	@Test(priority=1,enabled=true)
	public void navigatepage(){
		Simplefor.menuSelection();
	}
	@Test(priority=2,enabled=true)
	public void validateTitle(){
		String title=Simplefor.validatePageTitle();
		Assert.assertEquals(title,"Selenium Easy - Best Demo website to practice Selenium Webdriver Online");
		
	}
	@Test(priority=3,enabled=true)
	public void msgTest(){
		Simplefor.menuSelection();
		String sndMsg="Hi How Are you";
		Simplefor.enterMessage(sndMsg);
		String rcdMsg=Simplefor.getMessage();
		Assert.assertEquals(sndMsg,rcdMsg);
	}
	@DataProvider
	public Object[][] getAddData(){
	Object data[][]=TestUtil.getTestData(SheetName);
	System.out.println(data[0][0]+"data[0][0]");
	System.out.println(data[0][1]+"data[0][1]");
	System.out.println(data[1][0]+"data[1][0]");
	System.out.println(data[1][1]+"data[1][1]");
	System.out.println(data[2][0]+"data[2][0]");
	System.out.println(data[2][1]+"data[2][1]");
	System.out.println(data[3][0]+"data[3][0]");
	System.out.println(data[3][1]+"data[3][1]");
	System.out.println(data[4][0]+"data[4][0]");
	System.out.println(data[4][1]+"data[4][1]");
	return data;
	}
	@Test(priority=4, enabled=false,dataProvider="getAddData")
	public void sum(String Num1,String Num2){
		Simplefor.menuSelection();
		Integer Num11=Integer.valueOf(Num1);
		Integer Num12=Integer.valueOf(Num2);
		Integer Total=Num11+Num12;
		
		String exTotal=Total.toString();
		String rcdTotl=Simplefor.addNumber(Num11, Num12);
		Assert.assertEquals(exTotal, rcdTotl);
	}
	
	@AfterMethod(enabled=true)
	public void tearDown(){
		driver.quit();
	
	}
	
	}


