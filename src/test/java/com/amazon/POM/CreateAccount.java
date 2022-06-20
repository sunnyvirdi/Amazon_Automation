package com.amazon.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.BaseClass;

public class CreateAccount extends BaseClass{
	
	@FindBy(xpath="//a[@id='nav-link-accountList']") WebElement AccountList;
	@FindBy(xpath="//div[@id='nav-flyout-ya-newCust']//a[contains(text(),'Start here.')]") WebElement Start_here;
	@FindBy(id="ap_customer_name") WebElement yourname;
	@FindBy (id="ap_email") WebElement email;
	@FindBy (id="ap_password") WebElement password;
	@FindBy (id="ap_password_check") WebElement passwordagain;
	@FindBy (id="continue") WebElement continuebtn;
	@FindBy (xpath="//div[contains(text(),'Enter your name')]") WebElement NameErr;
	@FindBy (xpath="//div[contains(text(),'Enter your e-mail address or mobile phone number')]") WebElement emailErr;
	@FindBy (xpath="//div[@id='auth-password-missing-alert']//div[contains(text(),'Minimum 6 characters required')]") WebElement pswrdErr;
	@FindBy (xpath="//div[contains(text(),'Type your password again')]") WebElement paswrdagnErr;
	@FindBy (xpath="//div[contains(text(),'Passwords do not match')]") WebElement passwordntm;
	@FindBy (xpath="//span[contains(text(),'Verify mobile number')]") WebElement verifymob;
	@FindBy (xpath="//span[contains(text(),'Verify email')]") WebElement verifyemail;
	
	
	public CreateAccount() {
		PageFactory.initElements(driver, this);
		}
	public void mousehover() {
	Actions action = new Actions(driver);
	action.moveToElement(AccountList).build().perform();
	Start_here.click();
		
	}
	
	
	
	public void CreateNewAccount(String name, String Email, String paswrd, String paswrdagn) throws InterruptedException {
		yourname.sendKeys(name);
		Thread.sleep(2000);
		email.sendKeys(Email);
		Thread.sleep(2000);
		password.sendKeys(paswrd);
		Thread.sleep(2000);
		passwordagain.sendKeys(paswrdagn);
		Thread.sleep(2000);	
		}
	
	public void click () {
		continuebtn.click();
	}
	
	public String   ErrorMessage() {
	String err=	NameErr.getText();
	return err;
	}
	
	public String emailerror() {
		String emailerr= emailErr.getText();
		return emailerr;
	}
	
	public String passwordErro() {
		String pswderr= pswrdErr.getText();
		return pswderr;
	}
	
	
	public String PasswordagainErr() {
		String pswrdagn= paswrdagnErr.getText();
		return pswrdagn;
	}
	
	public String Passwordnotmatch() {
		String pswrdnm= passwordntm.getText();
		return pswrdnm;
	}
	
	public String verifymobile() {
		String verifymb= verifymob.getText();
		return verifymb;
	}
	
	public String verifyemail() {
		String verifyeml= verifyemail.getText();
		return verifyeml;
	}
	
	
}
