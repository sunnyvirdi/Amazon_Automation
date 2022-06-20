package com.amazon.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.BaseClass;

public class SignInPOM extends BaseClass{
	
	
	@FindBy(xpath="//a[@id='nav-link-accountList']") WebElement AccountList;
	@FindBy(xpath="//span[@class='nav-action-inner' and contains(text(),'Sign in')]") WebElement Sign_in;
	@FindBy(id="ap_email") WebElement email_Address;
	@FindBy(xpath="//input[@class='a-button-input']") WebElement continuebtn;
	@FindBy(xpath="//input[@id='ap_password']") WebElement password;
	@FindBy(xpath="//input[@id='signInSubmit']") WebElement SignInbtn;
	@FindBy(xpath="//a[@id='nav-link-accountList']") WebElement HelloSunny;
	@FindBy(xpath="//span[contains(text(),'Your Account')]") WebElement youraccount;
	@FindBy (xpath="//div[contains(text(),'Enter your e-mail address or mobile phone number')]") WebElement SigninErr;
	@FindBy (xpath="//span[contains(text(),'We cannot find an account with that e-mail address')]") WebElement Invalidemail;
	@FindBy (xpath="//span[contains(text(),'We cannot find an account with that mobile number')]") WebElement phnErr;
	@FindBy (xpath="//div[contains(text(),'Enter your password')]") WebElement PswrdErr;
	@FindBy(xpath="//span[contains(text(),'Your password is incorrect')]") WebElement Incorectpswrd;
	@FindBy (xpath="//input[@type='checkbox']") WebElement checkbox;
	// now create the object of this class
	
	public SignInPOM() {
		PageFactory.initElements(driver, this);
	}
	public void mousehover() {
		Actions action= new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
		action.moveToElement(Sign_in).click().build().perform();
	}
	
	public void EnterEmail(String Email) throws InterruptedException {
		email_Address.sendKeys(Email);
	
	}
	public void EnterPassword(String Password) {
		password.sendKeys(Password);
	}
		
	public String EmailError() {
		String emlerr= SigninErr.getText();
		return emlerr;
	}
	
	public void Continuebutton() {
		continuebtn.click();
	}
	
	public void SignInButton() {
		SignInbtn.click();
	}
	
	public String Invalidemail() {
		String invalideml= Invalidemail.getText();	
		return invalideml;
	}
	
	public String passwordError() {
		String pswrderr= PswrdErr.getText();
		return pswrderr;
	}
	
	public String PhoneNumberError() {
		String Incorrectphone= phnErr.getText();
		return Incorrectphone;
	}
	
	public String IncorrectPassword() {
		String incrctpswrd= Incorectpswrd.getText();
		return incrctpswrd;
	}
	
	public void selectingCheckbox() {
		checkbox.click();
		
	}
	
	
	
	public YourAccountPOM mousehover2() {
		
		Actions action1= new Actions(driver);
		action1.moveToElement(HelloSunny).build().perform();
		action1.moveToElement(youraccount).click().build().perform();
		return new YourAccountPOM();
	}
		
	
}
