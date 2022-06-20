package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.amazon.POM.YourAddress;
import com.amazon.base.BaseClass;
import com.amazon.utils.TestUtils;

public class YourAddressTestCases extends BaseClass{
	
	public String SheetName="Your_Address";
	
	public static YourAddress Add;
	
	public YourAddressTestCases() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	
	
	@DataProvider
	public Object[][] getAddressTestdata(){
		Object data[][]=TestUtils.getTestData(SheetName);
		return data;
	}
	
	@Test (priority=1, dataProvider="getAddressTestdata")
	public void Address(String Condition, String FullName, String PhoneNum, String Address, String City,String PostalCode, String Buzzer ) throws InterruptedException {
		
	boolean con1=Condition.equals("Emp_Name");
	boolean con2=Condition.equals("Emp_PhnNo");
	boolean con3=Condition.equals("Emp_Add");
	boolean con4=Condition.equals("Emp_City");
	boolean con5=Condition.equals("Emp_Postal");
	boolean con6=Condition.equals("Wrng_Postal");
	boolean con7=Condition.equals("Valid");
		
	Add= new YourAddress();
	Add.loginmousehover();
	Thread.sleep(3000);
	Add.SignIn();
	Thread.sleep(2000);
	Add.youraddressMH();
	Thread.sleep(2000);
	Add.countryname();
	Add.AddAddress(FullName, PhoneNum, Address, City, PostalCode, Buzzer);
	
	if(con1) {
		String act= Add.countryname();
		Assert.assertEquals(act, "Canada");
		System.out.println(act);

	String Actual= Add.FullNameError();
	Assert.assertEquals(Actual, "Please enter a name.");
	System.out.println(Actual);
	}
	
	else if(con2) {
		String Actual1= Add.PhoneNumberError();
		Assert.assertEquals(Actual1, "Please enter a phone number so we can call if there are any issues with delivery.");
		System.out.println(Actual1);
	}
	else if (con3) {
		String actual2=Add.addressError();
		Assert.assertEquals(actual2, "Please enter an address.");
		System.out.println(actual2);
	}
	
	else if (con4) {
	 String Actual3= Add.CityError();
	 Assert.assertEquals(Actual3, "Please enter a city name.");
	 System.out.println(Actual3);
	}
		
	else if (con5)	{
		Add.countryname();
		String Actual5= Add.PostalcodeError();
		Assert.assertEquals(Actual5, "Please enter a postal code.");
		System.out.println(Actual5);
		
	}
	else if (con6) {
		String Actual6= Add.WrongPostal();
		Assert.assertEquals(Actual6, "The province/territory and postal code that you provided do not match.");
		System.out.println(Actual6);
	}
	else if (con7) {
		Add.AddressSaved();
		String Actual7= Add.AddressSaved();
		Assert.assertEquals(Actual7, "Address saved");
		System.out.println(Actual7);
	}
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.quit();

	}
	
	
	
	
	
	
	
	
	
	
}
