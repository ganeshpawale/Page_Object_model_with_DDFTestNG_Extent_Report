package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	public LoginPage loginPage;
	public HomePage homePage;
	
	public LoginPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException 
	{
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTest() {
		
	String title=loginPage.validateloginPageTitle();
	Assert.assertEquals(title,"Free CRM in the cloud software boosts sales");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() 
	{
		boolean flag = loginPage.validateCrmImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() 
	{
		homePage=loginPage.login(pro.getProperty("username"),pro.getProperty("password"));
	}
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
}
