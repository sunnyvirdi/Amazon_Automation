package com.amazon.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.BaseClass;

public class CreateAccount extends BaseClass{
	
	
@FindBy(id="email") WebElement username;
@FindBy(id="ap_email") WebElement email;
@FindBy(id="pass") WebElement password;
@FindBy(id="ap_password_check") WebElement passwordagain;
@FindBy(id="u_0_d_Yh") WebElement loginbtn;



// initialize the page object ();
// first create the constructor of this class

	public CreateAccount() {
	PageFactory.initElements(driver, this);
	}
	// actions
	
	public void typeyourname(String name) {
		username.sendKeys(name);
	}
	
	
	public void enteremail(String Email) {
		
		email.sendKeys(Email);
	}
	
	public void Typepassword (String Pswrd) {
		password.sendKeys(Pswrd);
		
	}
	public void TypePasswordagain(String PA) {
		passwordagain.sendKeys(PA);
	}

	public void clickonlogin() {
		loginbtn.click();
	}
 
	

}

