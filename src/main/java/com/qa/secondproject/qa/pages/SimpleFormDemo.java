package com.qa.secondproject.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.secondproject.qa.base.TestBase;

public class SimpleFormDemo extends TestBase {
	
	//Page Factory OR
	
	String str1;
	@FindBy(partialLinkText="Input Forms")
	WebElement InForm;
	@FindBy(partialLinkText="Simple Form Demo")
	WebElement SimpFordemo;
	@FindBy(xpath="//input[@id='user-message']")
	WebElement MsgTextbox;
	@FindBy(id="display")
	WebElement displayarea;
	@FindBy(xpath="//button[contains(text(),'Show Message')]")
	WebElement MsgShowButton;
	@FindBy(id="sum1")
	WebElement TextNum1;
	@FindBy(id="sum2")
	WebElement TextNum2;
	@FindBy(id="displayvalue")
	WebElement displayvalue;
	@FindBy(xpath="//button[contains(text(),'Get Total')]")
	WebElement showButon;
	
	public SimpleFormDemo(){
		PageFactory.initElements(driver, this);
	}
	public void menuSelection(){
		
		InForm.click();
		SimpFordemo.click();
		
	}
	
	public String validatePageTitle(){
		return driver.getTitle();
			}
	
	public void enterMessage(String msg){
		
		MsgTextbox.sendKeys(msg);
		MsgShowButton.click();
				
	}
	public String getMessage(){
		return displayarea.getText();
	}
	public String addNumber(Integer num1,Integer num2){
		String str1=num1.toString();
		String str2=num2.toString();
		TextNum1.sendKeys(str1);
		TextNum2.sendKeys(str2);
		showButon.click();
		return displayvalue.getText();
		
		
	}
	
	
}

