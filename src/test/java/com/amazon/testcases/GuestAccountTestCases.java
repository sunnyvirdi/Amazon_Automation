package com.amazon.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.POM.GuestAccountPOM;
import com.amazon.base.BaseClass;

public class GuestAccountTestCases extends BaseClass{
	
	public static GuestAccountPOM GA;
	public GuestAccountTestCases() {
	
	super();
	}

@BeforeMethod
public void Yourorders() {
	initialization();
}

@Test
public void GuestAccount() throws InterruptedException {
	GA= new GuestAccountPOM();
	GA.SearchField();
	Thread.sleep(2000);
	GA.SearchItem();
	Thread.sleep(2000);
	GA.SearchSelection();
	Thread.sleep(2000);
	GA.CartItem();
	Thread.sleep(2000);
	GA.ProceedToCheckout();
	Thread.sleep(2000);
	
}

@AfterMethod
public void closebrowser() {
	driver.quit();
}


















}
