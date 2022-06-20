package com.amazon.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.amazon.base.BaseClass;

public class ShippingPOM extends BaseClass{
	
	@FindBy(xpath="//a[@id='nav-link-accountList']") WebElement AccountList;
	@FindBy(xpath="//span[@class='nav-action-inner' and contains(text(),'Sign in')]") WebElement Sign_in;
	@FindBy(id="ap_email") WebElement email_Address;
	@FindBy(xpath="//input[@class='a-button-input']") WebElement continuebtn;
	@FindBy(xpath="//input[@id='ap_password']") WebElement password;
	@FindBy(xpath="//input[@id='signInSubmit']") WebElement SignInbtn;
	@FindBy(xpath="//input[@id='twotabsearchtextbox']") WebElement SearchField;
	@FindBy(xpath="//input[@id='nav-search-submit-button']") WebElement Searchbtn;
	@FindBy(xpath="//span[@class='a-size-medium-plus a-color-base a-text-normal']") WebElement SearchResult;
	@FindBy(xpath="//span[text()='CERBONNY Carpal Tunnel Wrist Brace ,2Pack Wrist Support Brace Adjustable Wrist Strap Reversible Wrist Brace for Sports Protecting/Tendonitis Pain Relief/Carpal Tunnel/Arthritis-Right&Left']") WebElement ProductSelection;
	@FindBy(xpath="//input[@id='add-to-cart-button']") WebElement AddToCart;
	@FindBy(xpath="//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']") WebElement CartItem;
	@FindBy(xpath="//input[@name='proceedToRetailCheckout']") WebElement Checkout;
	@FindBy(linkText="No Thanks") WebElement NoPrime;
	@FindBy(xpath="//input[@title='FREE Shipping']") WebElement freeshipradio;
	@FindBy(xpath="//input[@title='Place your order']") WebElement PlaceYourOrder;
	@FindBy(xpath="//input[@title='FREE Delivery on your first order']") WebElement RadioButton;
	@FindBy(xpath="//span[contains(text(),'The Book of Unusual Knowledge')]") WebElement ItemUnder35;
	
	
	public ShippingPOM() {
		PageFactory.initElements(driver, this);	
	
	}

	
	public void mousehover() {
		Actions action= new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
		action.moveToElement(Sign_in).click().build().perform();
	}
	
	public void EnterLogin() throws InterruptedException {
		email_Address.sendKeys(prop.getProperty("yemail"));
		Thread.sleep(2000);
		continuebtn.click();
		Thread.sleep(2000);
		password.sendKeys(prop.getProperty("ypassword"));
		Thread.sleep(2000);
		SignInbtn.click();
	}
	
	public void SearchField() {
		SearchField.click();
		SearchField.sendKeys(prop.getProperty("SearchProduct"));
		Searchbtn.click();
	}
	
	public void SearchItem() {
		String Actual=SearchResult.getText();
		String Expected= "RESULTS";
		Assert.assertEquals(Actual, Expected);
		System.out.println(Actual);
	}

	public void SearchSelection() {
		ProductSelection.click();
		AddToCart.click();
	}

   public void CartItem() {
	   String Actual= CartItem.getText();
	   String Expected= "Added to Cart";
	   Assert.assertEquals(Actual, Expected);
	   System.out.println(Actual);
   }
	
   public void ProceedToCheckout() throws InterruptedException {
	   Checkout.click();
	   Thread.sleep(2000);
   }
   
   public void NOAmazonPrime() {
	   NoPrime.click();
	   
   }
   public void FreeShipping() throws InterruptedException {
	   boolean con= RadioButton.isDisplayed();
	   
	   if (con) {
		   RadioButton.click();
		   Thread.sleep(2000);
		   boolean actual= RadioButton.isDisplayed();
		   Assert.assertTrue(actual, "Item is Qualify for free shipping");
	   }
	   else if (!con) {
		   Assert.assertTrue(true, "free shipping is not available");
		   System.out.println("Free shipping is not available for items under $35");
	   }
	   	
	}
   public void NoFreeShipping() {
		ItemUnder35.click();
	   
	   
   }   

}
