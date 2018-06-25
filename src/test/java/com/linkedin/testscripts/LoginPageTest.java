package com.linkedin.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.linkedin.base.TestBase;
import com.linkedin.pages.HomePage;
import com.linkedin.pages.LoginPage;



public class LoginPageTest extends TestBase  
{ 
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	
	Logger log = Logger.getLogger(HomePageTest.class);
	
	
	
	@BeforeMethod
	public void setUp(){ 
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=3) 
	public void loginPageTitleTest() 
	{ 
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "LinkedIn: Log In or Sign Up");
	}
	
	@Test(priority=2)
	public void LogoImageTest(){
		boolean flag = loginPage.validatelinkedinimage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=1)
	public void loginTest() throws InterruptedException{
		//here the username and password are taken from the config file as it is read from test base
		// homePge is a reference object for the Homepage object created above
		log.info("Passing credential , this is from log 4J");
	
		//System.out.println("passing cred");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("entred cred");
		Thread.sleep(15000);
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
