package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	LoginPage loginpage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactPage;
	public HomePageTest() 
	{
		super();
	}
	
  	@BeforeMethod
  	public void setUp() throws InterruptedException 
  	{
  		initialization();
  		testUtil =new TestUtil();
		loginpage = new LoginPage();
		contactPage= new ContactsPage();
		homePage=loginpage.login(pro.getProperty("username"),pro.getProperty("password"));

  	}
  	@Test(priority=1)
  	public void verifyHomePageTitleTest() 
  	{
  		String homePageTitle=homePage.verifyHomePage();
  		Assert.assertEquals(homePageTitle, "CRMPRO","Home Page title not matched");
  		
  	}
  	
  	@Test(priority=2)
  	public void verifyUsernameTest() 
  	{
  		testUtil.switchToFrame();
  		Assert.assertTrue(homePage.verifyCorrectUserName());
  		
  	} 
  	
  	@Test(priority=3)
  	public void verifyContactsLinkTest() 
  	{
  		testUtil.switchToFrame();
  		contactPage=homePage.clickonContactLink();
  	}
  	
  	
  	
  	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}

}
