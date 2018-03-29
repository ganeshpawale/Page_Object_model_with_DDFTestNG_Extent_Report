package com.crm.qa.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.util.TestUtil;

public class RoughTest {

	ContactsPage contactPage;
	public static String sheetName="contacts";
	
	    @DataProvider
	    public Object[][] getCRMTestData() 
	    {
	    	Object data[][]=TestUtil.getTestData(sheetName);
	    	return data;
	    }
	    
	    @Test(priority=1,dataProvider="getCRMTestData")
	    public void Demo(String title,String firstName,String lastName,String company) 
	    {
	    	System.out.println(title+"..."+firstName+"..."+lastName+"..."+company);
	    }
	    
}
