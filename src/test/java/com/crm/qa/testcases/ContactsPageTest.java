package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactPage;
	public static String sheetName="contacts";
	public ContactsPageTest() 
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
		testUtil.switchToFrame();
	    contactPage= homePage.clickonContactLink();

  	}
  	
    @Test(priority=1) 
    public void verifyContactsLabel() throws InterruptedException 
    {
    	Thread.sleep(5000);
    	Assert.assertTrue(contactPage.verifyContactsLabel(),"Contacts label missing on the page");
    }
  	
    @Test(priority=2)
    public void selectSingleContactsByName() throws InterruptedException 
    {
    	Thread.sleep(5000);
    	contactPage.selectContactsByName("Ganesh Pawale");
    	Thread.sleep(3000);
    }
    
    @Test(priority=3)
    public void selectMultipleContactsByName() throws InterruptedException 
    {
    	Thread.sleep(5000);
    	contactPage.selectContactsByName("Mangesh Pawale");
    	contactPage.selectContactsByName("Ganesh Pawale");
    	Thread.sleep(3000);
    }
    
    @Test(priority=4,dataProvider="getCRMTestData")
    public void validateCreateNewContact(String title,String firstName,String lastName,String company) throws InterruptedException 
    {
    	homePage.clickNewContactLink();
    	Thread.sleep(3000);
    	contactPage.createNewContact(title,firstName,lastName,company);
    	Thread.sleep(3000);
    }
    
    @DataProvider
    public Object[][] getCRMTestData() 
    {
    	Object data[][]=TestUtil.getTestData(sheetName);
    	return data;
    }
    
  
    
  /*  @Test(priority=1,dataProvider="getCRMTestData")
    public void Demo(String title,String firstName,String lastName,String company) 
    {
    	System.out.println(title+"..."+firstName+"..."+lastName+"..."+company);
    }
    */
  	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}


}
