package com.qa.base;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.TestUtil;


public class BaseTestClass 
{
	
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseTestClass() 
	{
		prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Users\\akank\\eclipse-workspace\\PageObjectModelHybridFramework\\src\\main\\java\\com\\qa\\config\\config.properties");
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void intializationSteps() 
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Study\\Selenium\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\Study\\Selenium\\geckodriver-v0.34.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		
		driver.get(prop.getProperty("url"));
	}
	
}
