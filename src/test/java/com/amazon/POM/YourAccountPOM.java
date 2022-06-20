package com.amazon.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.BaseClass;

		public class YourAccountPOM extends BaseClass{
		@FindBy(xpath="//a[@id='nav-link-accountList']") WebElement AccountList;
		@FindBy(xpath="//span[@class='nav-action-inner' and contains(text(),'Sign in')]") WebElement Sign_in;
		@FindBy(xpath="//span[contains(text(),'Your Account')]") WebElement youraccount;
		@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']") WebElement HelloSunny;
		@FindBy(id="ap_email") WebElement email_Address;
		@FindBy(xpath="//input[@class='a-button-input']") WebElement continuebtn;
		@FindBy(xpath="//input[@id='ap_password']") WebElement password;
		@FindBy(xpath="//input[@id='signInSubmit']") WebElement SignInbtn;
		// once you have stare the value of web element after that you have to create the constructor of this class

		public YourAccountPOM() {
		PageFactory.initElements(driver, this);
		}



		public void mousehover() {
		Actions action= new Actions(driver);
		action.moveToElement(AccountList).build().perform();
		action.moveToElement(Sign_in).click().build().perform();

		}
		public void EnterEmailandPassword() throws InterruptedException {
			email_Address.sendKeys(prop.getProperty("yemail"));
			Thread.sleep(2000);
			continuebtn.click();
			Thread.sleep(2000);
			password.sendKeys(prop.getProperty("ypassword"));
			Thread.sleep(2000);
			SignInbtn.click();
			
		}
		
		public String gettitle() {
			String title= driver.getTitle();
			return title;
		}

		public String getUsername() {
			String username= HelloSunny.getText();
			return username;
		
			
			
		}
		public void YourAccountmousehover() {
		Actions action1= new Actions(driver);
		action1.moveToElement(AccountList).build().perform();
		action1.moveToElement(youraccount).click().build().perform();
	

		}}
		
		
		
