package com.amazon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.utils.TestUtils;

public class BaseClass {

 public static WebDriver driver;
 public static Properties prop;
	
	public BaseClass(){
		
		prop= new Properties();
		
			
			FileInputStream file;
			try {
				file = new FileInputStream("C:\\Users\\sunny\\eclipse-workspace\\MavenAutomation\\src\\test\\java\\com\\amazon\\config\\config.properties");
				  prop.load(file);
			} 
			
			catch (FileNotFoundException e) {
			
				e.printStackTrace();
			} 
			catch (IOException a) {
			
				a.printStackTrace();
			}
	      	
		}
	
	
	public static void initialization() {
	String browsername=	prop.getProperty("browser");
	
	if(browsername.equals("chrome")) {
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		driver= new ChromeDriver();
	}
	else if (browsername.equals("Firefox")) {
		System.setProperty("Webdriver.gecko.driver", "geckodriver.exe");
		driver= new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtils.Timeout_page_loadout, TimeUnit.SECONDS); // call static variable of long wait instead of changing time manually
	driver.manage().timeouts().implicitlyWait(TestUtils.Implicit_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}
	
	
	
	
}
