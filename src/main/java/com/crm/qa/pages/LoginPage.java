package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page factory---OR
	//@findBy to find the elements and we use initElements method to initialize web elements.
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive') and @src='https://d19rqa8v8yb76c.cloudfront.net/img/freecrm.jpg']")
	WebElement crmLogo;
	
	//initializing the Page Objects:
	//We use initElements method to initialize web elements
	public LoginPage() 
	{
		PageFactory.initElements(driver,this);
	}
	
	//Actions:
	public String validateloginPageTitle() 
	{
		return driver.getTitle();
	}
	
	
	
	public boolean validateCrmImage() 
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) 
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
}
