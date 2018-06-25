package com.linkedin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.linkedin.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - OR:
		@FindBy(how = How.NAME,using="session_key")
		public WebElement username;
		
		//This is the format of using How [format of page factory on identifying elements]
		//Both ways of with and without using How[ the above normal way] can also be used here
		
		@FindBy(how = How.CLASS_NAME,using= "login-password")
		public WebElement password;
		
		@FindBy(id="login-submit")
		WebElement loginBtn;
		
		@FindBy (xpath ="//img[@class='lazy-loaded']")
		WebElement linkedinimage;
		
		//Initializing the Page Objects by creating a constructor [elements declared above are initialized]
		public LoginPage() 
		{
			PageFactory.initElements(driver, this);
		}
		
		//Actions or methods for login page
		public String validateLoginPageTitle()
		{
			return driver.getTitle();
			
		}
		
		public boolean validatelinkedinimage()
		{
			return linkedinimage.isDisplayed();
		}
		
		public HomePage login(String uname, String pword){
			
			System.out.println("passing uname");
			username.sendKeys(uname);
		//	driver.findElement(By.name("session_key")).sendKeys(uname);
			System.out.println("uname passed");
			password.clear();
		//	driver.findElement(By.className("login-password")).sendKeys(uname);			
			password.sendKeys(pword);
			System.out.println("pwd passed");
		//	driver.findElement(By.id("login-submit")).click();
			loginBtn.click();
			System.out.println("logged in");
			return new HomePage();
		}
		
		

}
