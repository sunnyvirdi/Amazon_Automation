package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.POM.YourPaymentPOM;
import com.amazon.base.BaseClass;

	public class YourPayementTestCases extends BaseClass{
	public static	YourPaymentPOM yp;
	public YourPayementTestCases() {
	super();
		
	}
	
	@BeforeMethod
	public void YourPayement() throws InterruptedException {
	initialization();
	yp= new YourPaymentPOM();
	yp.mousehover();
	Thread.sleep(2000);
	yp.EnterEmail();
	yp.UserAccountMouseHover();
	Thread.sleep(2000);
	
	}

	@Test(priority=1)
	public void Login() throws InterruptedException {
	yp.addpayment();
	Thread.sleep(2000);
	}

	@Test(priority=2)
	public void AddCardDetails() throws InterruptedException {
	
	yp.addpayment();
	Thread.sleep(2000);
	yp.AddYourCard();
	Thread.sleep(2000);
	yp.SwitchToCardDetails();
	Thread.sleep(2000);
	yp.EnterCardNUmber();
	Thread.sleep(2000);
	yp.EnterName();
	Thread.sleep(2000);
	yp.Selectdate();
	Thread.sleep(2000);
	yp.SelectYear();
	Thread.sleep(2000);
	yp.AddYourCard();
	Thread.sleep(2000);
	yp.SaveCardDetails();
	Thread.sleep(2000);
	driver.switchTo().defaultContent();
	yp.PaymentMethodSuccess();
	Thread.sleep(2000);
	}
	@Test (priority=3)
	public void UpdatePreferences() throws InterruptedException {	
	
	yp.GoToSetting();
	Thread.sleep(2000);
	yp.ChangePreference();
	Thread.sleep(5000);
	yp.DefaultSelection();
	Thread.sleep(2000);
	yp.clickWallet();
	Thread.sleep(2000);
	yp.defaultCard();
	
}




	@AfterMethod
	public void closebrowser() {
	driver.quit();
	}}

