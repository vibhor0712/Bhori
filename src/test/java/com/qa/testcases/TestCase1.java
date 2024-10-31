package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTestClass;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;

public class TestCase1 extends BaseTestClass
{
	
	LoginPage lp;
	ProductsPage pp;
	
	public TestCase1()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		intializationSteps();
		lp = new LoginPage();
		
	}
	
	
	@Test
	public void loginPageLogoTest()
	{
		lp.validateLoginImage();
	}
	
	@Test
	public void loginPageTitle()
	{
		String title = lp.validatePageTitle();
		Assert.assertEquals(title, "Swag Labs");
	}
	

	@Test
	public void loginIntoSwagLabPortal()
	{
		pp=lp.loginIntoPortal(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void endTest()
	{
		driver.quit();
	}
}
