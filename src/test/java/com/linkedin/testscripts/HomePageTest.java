package com.linkedin.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.linkedin.base.TestBase;
import com.linkedin.pages.HomePage;
import com.linkedin.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	
	public HomePageTest() {
		super();
	}
	
	Logger log = Logger.getLogger(HomePageTest.class);
	
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	@Test
	public void verifyHomePageTitle(){
		boolean flag = homePage.validateHomePageIcon();
		Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	

}
