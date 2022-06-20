package com.amazon.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.base.BaseClass;

public class YourAddress extends BaseClass{
	
	@FindBy (xpath="//a[@id='nav-link-accountList']") WebElement AccountList;
	@FindBy (xpath="//span[@class='nav-action-inner' and contains(text(),'Sign in')]") WebElement Sign_in;
	@FindBy (id="ap_email") WebElement email_Address;
	@FindBy (xpath="//input[@class='a-button-input']") WebElement continuebtn;
	@FindBy (xpath="//input[@id='ap_password']") WebElement password;
	@FindBy (xpath="//input[@id='signInSubmit']") WebElement SignInbtn;
	@FindBy (xpath="//span[contains(text(),'Your Account')]") WebElement youraccount;
	@FindBy (xpath="//h2[contains(text(),'Your Addresses')]") WebElement address;
	@FindBy (xpath="//div[@class='a-box first-desktop-address-tile']") WebElement addAddress;
//	@FindBy (xpath="//select[@name='address-ui-widgets-countryCode']") WebElement Country;
	@FindBy (xpath="//span[@class='a-button-text a-declarative']") WebElement Country;
	@FindBy (xpath="//input[@id='address-ui-widgets-enterAddressFullName']") WebElement Fullname;
	@FindBy (xpath="//input[@id='address-ui-widgets-enterAddressPhoneNumber']") WebElement PhoneNumber;
	@FindBy (xpath="//input[@id='address-ui-widgets-enterAddressLine1']") WebElement Address1;
	@FindBy (xpath="//input[@id='address-ui-widgets-enterAddressCity']") WebElement city;
	@FindBy (xpath="//input[@id='address-ui-widgets-enterAddressPostalCode']") WebElement postal;
	@FindBy (xpath="//input[@id='address-ui-widgets-use-as-my-default']") WebElement checkbox;
	@FindBy (xpath="//input[@id='address-ui-widgets-addr-details-gate-code']") WebElement buzzer;
	@FindBy (xpath="//select[@name='address-ui-widgets-addr-details-business-hours']") WebElement choosedays;
//	@FindBy (xpath="//select[@name='address-ui-widgets-addr-details-business-hours']") WebElement dontDeliver;
	@FindBy (xpath="//select[@name='address-ui-widgets-enterAddressStateOrRegion']") WebElement province;
	@FindBy (xpath="//span[@id='address-ui-widgets-form-submit-button']") WebElement submitbtn;
	@FindBy (xpath="//div[contains(text(),'Please enter a name.')]") WebElement nameErr;
	@FindBy (xpath="//div[contains(text(),'Please enter a phone number so we can call if there are any issues with delivery.')]") WebElement phoneErr;
	@FindBy (xpath="//div[contains(text(),'Please enter an address.')]") WebElement AddressErr;
	@FindBy (xpath="//div[contains(text(),'Please enter a city name.')]") WebElement CityErr;
	@FindBy (xpath="//div[contains(text(),'Please enter a province/territory.')]") WebElement provinceErr;
	@FindBy (xpath="//div[contains(text(),'Please enter a postal code.')]") WebElement postalErr;
	@FindBy (xpath="//div[contains(text(),'The province/territory and postal code that you provided do not match.')]") WebElement WrongPostal;
	@FindBy (xpath="//input[@id='address-ui-widgets-original-address-block_id-input']") WebElement originalAdd;
	@FindBy (xpath="//input[@name='address-ui-widgets-saveOriginalOrSuggestedAddress']") WebElement saveAdd;
	@FindBy (xpath="//div//span[@class='a-size-small a-color-secondary default-line-item']") WebElement DefaultAdd;
	public YourAddress() {
		PageFactory.initElements(driver, this);
	}
	
	public void loginmousehover() {
		Actions action = new Actions(driver);
		action.moveToElement(AccountList).build().perform();
		action.moveToElement(Sign_in).click().build().perform();
	//	String title=driver.getTitle();
	//	System.out.println(title);
	}
	public void SignIn() throws InterruptedException {
		email_Address.sendKeys(prop.getProperty("yemail"));
		continuebtn.click();
		Thread.sleep(3000);
		password.sendKeys(prop.getProperty("ypassword"));
		SignInbtn.click();
		Thread.sleep(3000);
		
	}
	public void youraddressMH() throws InterruptedException {
		Actions action1= new Actions(driver);
		action1.moveToElement(AccountList).build().perform();
		action1.moveToElement(youraccount).click().perform();
		Thread.sleep(2000);
		address.click();
		Thread.sleep(2000);
		addAddress.click();
				
	}
	
	public void AddAddress(String Name, String PhoneNum, String Address, String City, String Postal, String Buzzer ) throws InterruptedException {
		Fullname.sendKeys(Name);
		Thread.sleep(5000);
		PhoneNumber.sendKeys(PhoneNum);
		Thread.sleep(5000);
		Address1.sendKeys(Address);
		city.sendKeys(City);
		Thread.sleep(5000);
		Select select= new Select(province);
		select.selectByVisibleText("Ontario");
		Thread.sleep(1000);
		postal.sendKeys(Postal);
		Thread.sleep(3000);
		checkbox.click();
		Thread.sleep(2000);
		buzzer.sendKeys(Buzzer);
		Thread.sleep(3000);
		//Select select1=new Select(choosedays);
		//select.selectByVisibleText("Don't deliver on weekends");
		submitbtn.click();
		Thread.sleep(4000);
		
//(String Name, String PhoneNum, String Address, String City, String Postal, String Buzzer )		
		
		
	}
	
	public String countryname() {
		String countryname= Country.getText();
		return countryname;
		
	}
	public String FullNameError() {
		String yourname= nameErr.getText();
		return yourname;
		
	}
	public String PhoneNumberError() {
		String phonenum= phoneErr.getText();
		return phonenum;
	}
	public String addressError() {
		String Add= AddressErr.getText();
		return Add;
		
	}
	public String CityError() {
		String city=CityErr.getText();
		return city;
	}
//	public void selectclass() {
//	Select select= new Select(province);
//	select.selectByVisibleText("Ontario");
//	}
	
	public String provinceError () {
		String pro=provinceErr.getText();
		return pro;
	}
	
	public String PostalcodeError() {
		String postal= postalErr.getText();
		return postal;
	}
	
	public String WrongPostal() {
		originalAdd.click();
		saveAdd.click();
		String wrngpostal= WrongPostal.getText();
		return wrngpostal;
	}
	public void checkbox() {
		checkbox.click();
	}
/*	public void DeliveryInstruction() {
//		choosedays.click();
//		dontDeliver.click();		
//	}
	
	  public void SaveAdd() {
		  originalAdd.click();
			saveAdd.click();
	  }
	  */
	 public String AddressSaved() throws InterruptedException {
		 originalAdd.click();
		 Thread.sleep(3000);
			saveAdd.click();
			Thread.sleep(3000);
		 String setDefault= DefaultAdd.getText();
		 return setDefault;
	 }
	//public void WeekendDelivery() {
		//Select select=new Select(dontDeliver);
		//select.selectByVisibleText("Don't deliver on weekends");
	//}
}
