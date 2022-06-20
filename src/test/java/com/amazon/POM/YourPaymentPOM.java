package com.amazon.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.amazon.base.BaseClass;

public class YourPaymentPOM extends BaseClass{
	
	@FindBy(xpath="//a[@id='nav-link-accountList']") WebElement AccountList;
	@FindBy(xpath="//span[@class='nav-action-inner' and contains(text(),'Sign in')]") WebElement Sign_in;
	@FindBy(id="ap_email") WebElement email_Address;
	@FindBy(xpath="//input[@class='a-button-input']") WebElement continuebtn;
	@FindBy(xpath="//input[@id='ap_password']") WebElement password;
	@FindBy(xpath="//input[@id='signInSubmit']") WebElement SignInbtn;
	@FindBy(xpath="//a[@id='nav-link-accountList']") WebElement HelloSunny;
	@FindBy(xpath="//span[contains(text(),'Your Account')]") WebElement youraccount;
	@FindBy(xpath="//h2[contains(text(),'Your Payments')]") WebElement Ypayment;
	@FindBy(linkText="Add a payment method") WebElement APMethod;
	@FindBy(id="apx-add-credit-card-action-test-id") WebElement ACCard;
	@FindBy(xpath="//input[@type='tel'and@class='a-input-text a-form-normal pmts-account-Number'and@name='addCreditCardNumber']") WebElement CNumber; // card number
	@FindBy(xpath="//input[@type='text'and@class='a-input-text a-form-normal apx-add-credit-card-account-holder-name-input'and@name='ppw-accountHolderName']") WebElement Name; // name
	@FindBy(name="ppw-expirationDate_month") WebElement DDropdown;
	@FindBy(name="ppw-expirationDate_year") WebElement YDropdown;
	@FindBy(xpath="//input[@class='a-button-input']") WebElement ACCEvent;
	@FindBy(name="ppw-widgetEvent:SavePaymentMethodDetailsEvent") WebElement SaveCard;
	@FindBy(xpath="//span[@class='a-color-success' and contains(text(),'Payment method added')]") WebElement Success;
	@FindBy(xpath="//a[contains(text(),'Settings')]") WebElement Settings;
	@FindBy(linkText="Change Preference") WebElement Preference;
	@FindBy(xpath="//span[@id='a-autoid-1']") WebElement makedefault;
	@FindBy(name="ppw-instrumentRowSelection") WebElement radio;
	@FindBy(xpath="//input[@name='ppw-widgetEvent:PreferencePaymentOptionSelectionEvent']") WebElement continueButton;
	@FindBy(xpath="//a[contains(text(),'Wallet')]") WebElement Wallet;
	@FindBy(xpath="//div[contains(text(),'Default')]") WebElement DefaultCard;
	@FindBy(xpath="//span[contains(text(),'Your purchase preferences')]") WebElement CardPreference;
	public YourPaymentPOM () {
		PageFactory.initElements(driver, this);
		;
	}
	public void mousehover() {
		Actions action= new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
		action.moveToElement(Sign_in).click().build().perform();	

	}
	public void EnterEmail() throws InterruptedException {
		email_Address.sendKeys(prop.getProperty("yemail"));
		continuebtn.click();
		password.sendKeys(prop.getProperty("ypassword"));
		SignInbtn.click();
	}
	
	public void UserAccountMouseHover() {
		
		Actions action1= new Actions(driver);
		action1.moveToElement(HelloSunny).build().perform();
		action1.moveToElement(youraccount).click().build().perform();
		Ypayment.click();
		
	}
	
	public void addpayment() {
		APMethod.click();
		
	}
	public void AddCard() {
		ACCard.click();
		
	}
	
	
	public void SwitchToCardDetails() {
	driver.switchTo().frame(0);
	
	}
	public void EnterCardNUmber() {
		CNumber.click();
		CNumber.sendKeys(prop.getProperty("CardNumber"));	
		
	}
	public void EnterName() {
		Name.click();
		Name.sendKeys(prop.getProperty("CardHolder"));
		
	}
	public void Selectdate() {
		Select obj=new Select(DDropdown);
		obj.selectByVisibleText("05");
	}
	public void SelectYear() {
		Select obj1=new Select(YDropdown);
		obj1.selectByVisibleText("2024");
	}
	
	public void AddYourCard() {
		ACCEvent.click();
	}
	
	public void SaveCardDetails() {
		SaveCard.click();
		
	}	
	public void PaymentMethodSuccess() {
	String actual=	Success.getText();
	String Expected= "Payment method added";
	Assert.assertEquals(actual, Expected);
	System.out.println(actual);
	}
	
	public void GoToSetting() {
		Settings.click();
		
		
	}
	public void ChangePreference() {
		Preference.click();
		String actual= CardPreference.getText();
		String expected= "Your purchase preferences";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		
	}
	public void DefaultSelection() {
		makedefault.click();
	}
	
	public void clickWallet() {
		Wallet.click();
	}
	
	public void SwitchToDefaultPayment() {
		driver.switchTo().frame(radio);
	}
		
	public void RadioButton() throws InterruptedException {
		radio.click();
		Thread.sleep(2000);
		continueButton.click();
		Thread.sleep(2000);
	}
	
	
	
	
	public void defaultCard() {
		String actual= DefaultCard.getText();
		String Expected= "Default";
		Assert.assertEquals(actual, Expected);
		System.out.println(actual);
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

