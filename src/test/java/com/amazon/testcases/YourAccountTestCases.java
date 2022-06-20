package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.POM.YourAccountPOM;
import com.amazon.base.BaseClass;
import com.amazon.utils.TestUtils;

public class YourAccountTestCases extends BaseClass {
	
	public static YourAccountPOM xyz;
	
	public YourAccountTestCases() {
		super();
	}
	
	@BeforeMethod
	public void YourAccount() {
		initialization();
	}	
	@Test
	public void yourAccount() throws InterruptedException {
		
		
		xyz= new YourAccountPOM();
		xyz.mousehover();
		Thread.sleep(2000);
		
		xyz.EnterEmailandPassword();
		Thread.sleep(2000);
		
		String Title= xyz.gettitle();
		Assert.assertEquals(Title, "Amazon.ca: Low Prices – Fast Shipping – Millions of Items");
		System.out.println(Title);
		Thread.sleep(2000);
		
		String Customername=xyz.getUsername();
		Assert.assertEquals(Customername, "Hello, Sunny");
		System.out.println(Customername);
		
		Thread.sleep(2000);
		
		xyz.YourAccountmousehover();
		Thread.sleep(2000);
		xyz.getUsername();
				
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.quit();
	}

}
