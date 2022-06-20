package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.POM.YourOrdersPOM;
import com.amazon.base.BaseClass;

public class YourOrdersTestCases extends BaseClass{
	
	public static YourOrdersPOM yourordr;
	public YourOrdersTestCases() {
		super();
	}
	
	@BeforeMethod
	public void Login() throws InterruptedException {
	initialization();
	yourordr= new YourOrdersPOM();
	yourordr.mousehover();
	Thread.sleep(2000);
	yourordr.login();
	Thread.sleep(2000);
	yourordr.yourordersMH();
			
	}	
	
	@Test(priority=1)
	public void YourOrders() throws InterruptedException {
	yourordr.PastMonthOrders();
	yourordr.LastThreeMonths();
	yourordr.CurrentYear();
	}

	@Test(priority=2)
	public void OtherOptions() throws InterruptedException {
	yourordr.BuyOrders();
	yourordr.NotShippedYet();
	yourordr.CancelledOrder();
		
	}
		
	@AfterMethod
	public void closebrowser() {
	driver.quit();
	}
	
	
	
	

	
}