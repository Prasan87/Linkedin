package com.linkedin.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.linkedin.util.TestUtil;

public class TestBase {
	
	//Creating global variables which can be accessed on other files 
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() 
	{
		
		// 		Below code will read the config.properties file
			try {
			prop = new Properties();
	/*		FileInputStream ip = new FileInputStream(System.getProperty("C:/Users/venkatac/Desktop/Workspace/ProjectSample/src/main/java/com/linkedin"
					+ "/config/config.properties")); */
			InputStream ip = TestBase.class.getClassLoader().getResourceAsStream("com/linkedin/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		
		// Below code will get the browser value from prop [config file] and pass it in string
		String browser = prop.getProperty("browser");
		
		 if(browser.equalsIgnoreCase("explorer"))
	        {
	            
	            System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
	            driver = new InternetExplorerDriver();
	        }
	        
	        else if(browser.equalsIgnoreCase("firefox"))
	        {
	            
	            driver = new FirefoxDriver();
	        }
	        
	        else if(browser.equalsIgnoreCase("chrome"))
	        {
	           
	            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");     
	            driver = new ChromeDriver();
	        }
		
				
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		

}
}
