package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.POM.SignInPOM;
import com.amazon.base.BaseClass;
import com.amazon.utils.TestUtils;

public class SignInTestCases extends BaseClass{
	
	
	public String SheetName= "Sign-In";
	public static SignInPOM abc;
	public SignInTestCases() {
		super();
	}

	@BeforeMethod
	public void SignIn() {
		initialization();
	}
	@DataProvider
	public Object[] SigninTestData()  {
	Object data[][]=TestUtils.getTestData(SheetName);
	return data;
	}


	@Test ( priority=1, dataProvider= "SigninTestData") 
	public void ExistingCustomer(String Condition, String Email, String Password) throws InterruptedException {
		boolean con1=Condition.equals("Emp_Email");
		boolean con2=Condition.equals("Partial_Email");
		boolean con3=Condition.equals("Partial_PhnNo");
		boolean con4=Condition.equals("Emp_Password");
		boolean con5=Condition.equals("Wrng_Password");
		boolean con6=Condition.equals("Valid");
		
		abc= new SignInPOM();
		abc.mousehover();
		Thread.sleep(1000);
		abc.EnterEmail(Email);
		Thread.sleep(2000);
		abc.Continuebutton();
		
		if (con1) {
		String actual= abc.EmailError();
		Assert.assertEquals(actual, "Enter your e-mail address or mobile phone number");
		System.out.println(actual);
		}
			else if (con2) {
			String actual1=abc.Invalidemail();
			Assert.assertEquals(actual1, "We cannot find an account with that e-mail address");
			System.out.println(actual1);
		 	}
		 
			else if (con3) {
			String actual2= abc.PhoneNumberError();
			Assert.assertEquals(actual2,"We cannot find an account with that mobile number");
			System.out.println(actual2);
		}
			
			else if (con4) {
			abc.EnterPassword(Password);
			Thread.sleep(2000);
			abc.SignInButton();
			Thread.sleep(2000);
			String Actual3= abc.passwordError();
			Assert.assertEquals(Actual3, "Enter your password");
			System.out.println(Actual3);
		}
			else if (con5)	{
			abc.EnterPassword(Password);
			Thread.sleep(5000);
			abc.SignInButton();
			String actual4= abc.IncorrectPassword();
			Assert.assertEquals(actual4, "Your password is incorrect");
			System.out.println(actual4);
				
			}
			else if (con6) {
				abc.EnterPassword(Password);
				Thread.sleep(2000);
				abc.selectingCheckbox();
				Thread.sleep(2000);
				abc.SignInButton();
				Thread.sleep(2000);
				abc.mousehover2();
			}
	}
	
	
	@AfterMethod
	public void closebowser() {
		driver.quit();
		
	}	
}


