package com.amazon.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.amazon.POM.CreateAccount;
import com.amazon.base.BaseClass;
import com.amazon.utils.TestUtils;

public class CreateAccountTestCases extends BaseClass{

	public String SheetName= "CreateAccount";
	
	public static CreateAccount obj;
	
	public CreateAccountTestCases() {
	super();
}

	@BeforeMethod
	public void setup() {
		initialization();
		
	}	
	
	@DataProvider
	public Object[][] getcreateaccountTestData()  {
	Object data[][]=TestUtils.getTestData(SheetName);
	return data;
			
	}
	@Test(priority=1, dataProvider="getcreateaccountTestData")
	public void name(String Condition, String yourname, String email, String password, String passwordagain) throws Exception {
		
		
	boolean con1=Condition.equals("Emp_na"); 
	boolean con2=Condition.equals("Emp_EM"); 
	boolean con3=Condition.equals("Emp_ps");
	boolean con4=Condition.equals("Emp_pa");
	boolean con5=Condition.equals("Valid");
	boolean con6=Condition.equals("Par_Mob");
	boolean con7=Condition.equals("Par_email");	
	boolean con8=Condition.equals("Ver_Auth");
		
	obj= new CreateAccount();
	obj.mousehover();
	Thread.sleep(6000);
	obj.CreateNewAccount(yourname, email, password, passwordagain);
	
	
	if(con1) {
	obj.click();
	String actual= obj.ErrorMessage();	
	Assert.assertEquals(actual, "Enter your name");
	System.out.println(actual);
	}
	
	else if(con2) {
	obj.click();
	String actual3= obj.emailerror();
	Assert.assertEquals(actual3, "Enter your e-mail address or mobile phone number");
	System.out.println(actual3);
		
	}
		
	else if(con3) {
	obj.click();
	String act=obj.passwordErro();
	Assert.assertEquals(act,"Minimum 6 characters required");
	System.out.println(act);
	}
	
	else if(con4) {
	obj.click();
	String act1= obj.PasswordagainErr();
	Assert.assertEquals(act1,"Type your password again");
	System.out.println(act1);
	}
	
	else if(con5) {
	obj.click();
	String actual2= obj.Passwordnotmatch();
	Assert.assertEquals(actual2,"Passwords do not match");
	System.out.println(actual2);
	}
	
	else if(con6) {
	String actual4= obj.verifymobile();
	Thread.sleep(4000);
	Assert.assertEquals(actual4, "Verify mobile number");
	System.out.println(actual4);
	
	}
	else if (con7) {
	String actual5= obj.verifyemail();
	Thread.sleep(4000);
	Assert.assertEquals(actual5, "Verify email");
	System.out.println(actual5);
		
		}
	else if (con8)	{
		obj.click();
	String actual6=driver.getTitle();
	Thread.sleep(2000);
	Assert.assertEquals(actual6, "Authentication required");
	System.out.println(actual6);
		
		
	}}

	
	
	
	@AfterMethod 
	public void closebrowser() {
		driver.quit();
	
	}
	
	
}

