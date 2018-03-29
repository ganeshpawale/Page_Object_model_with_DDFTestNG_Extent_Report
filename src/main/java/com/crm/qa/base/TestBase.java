package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EventListener;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties pro;
	
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public TestBase() 
	{
		pro= new Properties();
		try {
			FileInputStream fis = new FileInputStream("D:\\NaveenMavenProject\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			pro.load(fis);
		
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void initialization() throws InterruptedException 
	{
		String browserName = pro.getProperty("browser");
		if(browserName.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver","c://chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browserName.equals("EE")) 
		{
			System.setProperty("webdriver.gecko.driver","c://geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		else if(browserName.equals("IE")) 
		{
			driver= new InternetExplorerDriver();
		}
		else if(browserName.equals("Safari")) 
		{
			driver= new SafariDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		//now create object of EventListerHandler to register it with EventFiringWebDriver 
		eventListener =new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(pro.getProperty("url"));
		driver.navigate().refresh();
		Thread.sleep(3000);
	}
	
	
}
