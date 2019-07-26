package com.qa.secondproject.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.secondproject.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase(){
		try{
			prop= new Properties();
			FileInputStream ip= new FileInputStream("C:/Users/Diya/workspace/maven-demo/src/main/java/com/project"
					+"/qa/config/config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
			
		}
		
	}
	public static void initialization(){
		String browserName=prop.getProperty("browser");
		
		if (browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","F:\\Softwares\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_Wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}

}
