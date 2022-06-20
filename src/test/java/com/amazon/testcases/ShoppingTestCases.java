package com.amazon.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.POM.ShoppingPOM;
import com.amazon.base.BaseClass;

public class ShoppingTestCases extends BaseClass{
	
	public static ShoppingPOM shop;
	
	public ShoppingTestCases() {

}

@BeforeMethod
public void ShoppingCart() throws InterruptedException {
	initialization();
	shop= new ShoppingPOM();
	shop.mousehover();
	Thread.sleep(2000);
	shop.EnterLogin();
	Thread.sleep(2000);
}	
	
@Test(priority=1)
public void SearchItem() throws InterruptedException {
	shop.SearchField();
	Thread.sleep(2000);
	shop.SearchItem();
	Thread.sleep(2000);
	shop.SearchSelection();
	Thread.sleep(3000);
	shop.CartItem();
	Thread.sleep(2000);
	shop.clickOnCart();
	Thread.sleep(2000);
	shop.quantity();
	Thread.sleep(2000);
	
}

@Test(priority=2)
public void Cart() throws InterruptedException {
	shop.SearchAnotherItem();
	Thread.sleep(3000);
	shop.SelectItem();
	Thread.sleep(3000);
	shop.CartItem();
	Thread.sleep(3000);
	shop.clickOnCart();
	Thread.sleep(3000);
	shop.VerifyCart();
	Thread.sleep(3000);
	shop.deleteWristSupport();
	Thread.sleep(5000);
	shop.deleteall();
}
@AfterMethod
public void CloseBrowser() {
	driver.quit();
}
	
}


