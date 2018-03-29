package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//select[@class='select' and @name='title']")
	WebElement prefixTitle;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement companyName;
	
	@FindBy(xpath="//form[@id='contactForm']//following-sibling::input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public ContactsPage() 
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyContactsLabel() 
	{
		return contactsLabel.isDisplayed();
		
	}
	
	public void selectContactsByName(String name) 
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//child::input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title,String fName,String lName,String comp) throws InterruptedException 
	{
		Select select= new Select(prefixTitle);
		//driver.navigate().refresh();
		Thread.sleep(2000);
		select.selectByVisibleText(title);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		companyName.sendKeys(comp);
		Thread.sleep(4000);
		saveBtn.click();
		
	}
	
}