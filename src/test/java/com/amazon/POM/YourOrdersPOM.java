package com.amazon.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.amazon.base.BaseClass;

public class YourOrdersPOM extends BaseClass{
	
	@FindBy(xpath="//a[@id='nav-link-accountList']") WebElement AccountList;
	@FindBy(xpath="//span[@class='nav-action-inner' and contains(text(),'Sign in')]") WebElement Sign_in;
	@FindBy(id="ap_email") WebElement email_Address;
	@FindBy(xpath="//input[@class='a-button-input']") WebElement continuebtn;
	@FindBy(xpath="//input[@id='ap_password']") WebElement password;
	@FindBy(xpath="//input[@id='signInSubmit']") WebElement SignInbtn;
	@FindBy(xpath="//span[contains(text(),'Your Orders')]") WebElement yourorders;
	@FindBy(name="orderFilter") WebElement Orderdd;
	@FindBy(xpath="//span[@id='a-autoid-1-announce']//span")WebElement OrderHistory;
	@FindBy(xpath="//div[@class='a-section a-spacing-top-medium a-text-center']") WebElement order;
	@FindBy(linkText="Buy Again") WebElement BuyAgain;
	@FindBy(linkText="Not Yet Shipped") WebElement Notyetshipped;
	@FindBy(linkText="Cancelled Orders") WebElement Cancelled;
	@FindBy (xpath="//div[@class='a-section a-spacing-none a-spacing-top-small a-padding-base a-text-center']") WebElement Buy;
	@FindBy(xpath="//div[@class='a-section a-spacing-top-medium a-text-center']") WebElement shipped;
	
	public YourOrdersPOM() {
	
		PageFactory.initElements(driver, this);
	}
	
	public void mousehover() {
		Actions action= new Actions(driver);
		action.moveToElement(AccountList).build().perform();
		action.moveToElement(Sign_in).click().build().perform();
	}
	
	
	public void login() throws InterruptedException {
		email_Address.sendKeys(prop.getProperty("yemail"));
		Thread.sleep(2000);
		continuebtn.click();
		Thread.sleep(2000);
		password.sendKeys(prop.getProperty("ypassword"));
		Thread.sleep(2000);
		SignInbtn.click();
						
	}
		
	public void yourordersMH() {
		Actions action1= new Actions(driver);
		action1.moveToElement(AccountList).build().perform();
		action1.moveToElement(yourorders).click().build().perform();
		
		String title=driver.getTitle();
		Assert.assertEquals(title, "Your Orders");
		System.out.println(title);	
	}
	
	public void PastMonthOrders() throws InterruptedException{
		Select obj=new Select(Orderdd);
		obj.selectByVisibleText("the past 30 days");
		String actualresult = OrderHistory.getText();
		System.out.println(actualresult);
		String expectedresult = "the past 30 days";
		Assert.assertEquals(actualresult, expectedresult);
		
		Thread.sleep(2000);		
		String actual= order.getText();
		if(actual.contains("ORDER PLACED")) {
		Assert.assertTrue(actual.contains("ORDER PLACED"));
		System.out.println(actual);
		}
		else {
			String orders=order.getText();
			System.out.println(orders);
		}

		
	}
	
	public void LastThreeMonths() throws InterruptedException{
		Select obj=new Select(Orderdd);
		obj.selectByVisibleText("past 3 months");
		String actualresult1=OrderHistory.getText();
		System.out.println(actualresult1);
		String expectedresult1 = "past 3 months";
		Assert.assertEquals(actualresult1, expectedresult1);
		Thread.sleep(2000);	
		String actual= order.getText();
		if(actual.contains("ORDER PLACED")) {
		Assert.assertTrue(actual.contains("ORDER PLACED"));
		System.out.println(actual);
		}
		else {
			String orders=order.getText();
			System.out.println(orders);
		}
	}
	
	public void CurrentYear() throws InterruptedException{
		Select obj=new Select(Orderdd);
		obj.selectByVisibleText("2022");
		String actualresult2=OrderHistory.getText();
		System.out.println(actualresult2);
		String expectedresult2="2022";
		Assert.assertEquals(actualresult2, expectedresult2);
		Thread.sleep(2000);
		String actual= order.getText();
		if(actual.contains("ORDER PLACED")) {
		Assert.assertTrue(actual.contains("ORDER PLACED"));
		System.out.println(actual);
		}
		else {
			String orders=order.getText();
			System.out.println(orders);
		}}
	
		public void BuyOrders() throws InterruptedException {
			Thread.sleep(5000);
			boolean verifybutton= BuyAgain.isDisplayed();
			String abc= BuyAgain.getText();
			System.out.println(abc);
			BuyAgain.click();	
			Thread.sleep(2000);
			String actual= Buy.getText();
			if(actual.contains("Buy it again")) {
			Assert.assertTrue(actual.contains("Buy it again"));
			System.out.println(actual);
			}
			else {
				System.out.println(actual);
			}}
		public void NotShippedYet() throws InterruptedException {
			boolean verifybutton= Notyetshipped.isDisplayed();
			String abc= Notyetshipped.getText();
			System.out.println(abc);
			Notyetshipped.click();	
			Thread.sleep(2000);
			String actual= shipped.getText();
			if(actual.contains("Arriving")) {
			Assert.assertTrue(actual.contains("Arriving"));
			System.out.println(actual);
			}
			else {
				System.out.println(actual);
			}}

		
		public void CancelledOrder() throws InterruptedException {
			boolean verifybutton= Cancelled.isDisplayed();
			String abc= Cancelled.getText();
			System.out.println(abc);
			Cancelled.click();	
			Thread.sleep(2000);
			String actual= shipped.getText();
			if(actual.contains("Cancelled")) {
			Assert.assertTrue(actual.contains("Cancelled"));
			System.out.println(actual);
			}
			else {
				System.out.println(actual);
			}}
	}
	
  
	
	
