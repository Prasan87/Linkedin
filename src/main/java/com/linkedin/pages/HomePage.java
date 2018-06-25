package com.linkedin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.linkedin.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Factory - OR:
			@FindBy(how = How.CLASS_NAME,using="nav-item__icon")
		    WebElement homeicon;
			
			@FindBy(how = How.CLASS_NAME,using="widget-route")
		    WebElement viewerprofile;
			
			@FindBy(how = How.XPATH,using="//*[@id='ember6674']/h3/span")
		    WebElement viewermessage;
			
			
			
			//Initializing the Page Objects by creating a constructor [elements declared above are initialized]
			public HomePage() 
			{
				PageFactory.initElements(driver, this);
			}
			public boolean validateHomePageIcon()
			{
				return homeicon.isDisplayed();
			}
			public ViewProfilePage profile()
			{
				
				viewerprofile.click();
				viewermessage.isDisplayed();				
				
				return new ViewProfilePage();
			}
			
			
			
	
	

}
