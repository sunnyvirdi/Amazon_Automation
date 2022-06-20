package com.amazon.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.POM.GuestAccountPOM;
import com.amazon.POM.ShippingPOM;
import com.amazon.base.BaseClass;

public class ShippingTestCases extends BaseClass{
	
	public static ShippingPOM shop;
	public ShippingTestCases() {
	
	super();
	}

@BeforeMethod
public void Yourorders() throws InterruptedException {
	initialization();
	shop= new ShippingPOM();
	shop.mousehover();
	Thread.sleep(2000);
	shop.EnterLogin();
	Thread.sleep(2000);
}

@Test
public void SelectItem() throws InterruptedException {
	
	shop.SearchField();
	Thread.sleep(2000);
	shop.SearchItem();
	Thread.sleep(2000);
	shop.SearchSelection();
	Thread.sleep(2000);
	shop.CartItem();
	Thread.sleep(2000);
	shop.ProceedToCheckout();
	Thread.sleep(2000);
	//shop.NOAmazonPrime();
//	Thread.sleep(2000);
	shop.FreeShipping();
}

@AfterMethod
public void closebrowser() {
	driver.quit();

}}
