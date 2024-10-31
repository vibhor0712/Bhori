package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTestClass;

public class LoginPage extends BaseTestClass
{	
	@FindBy(id = "user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	@FindBy(xpath = "//div[@class='login_logo']")
	WebElement loginLogo;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateLoginImage(){
		return loginLogo.isDisplayed();
	}
	
	public String validatePageTitle(){
		return driver.getTitle();
	}
	
	public ProductsPage loginIntoPortal(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		
		return new ProductsPage();
	}
	
}
