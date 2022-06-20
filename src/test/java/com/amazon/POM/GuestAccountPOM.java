package com.amazon.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amazon.base.BaseClass;

	public class GuestAccountPOM extends BaseClass{
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']") WebElement SearchField;
	@FindBy(xpath="//input[@id='nav-search-submit-button']") WebElement Searchbtn;
	@FindBy(xpath="//span[@class='a-size-medium-plus a-color-base a-text-normal']") WebElement SearchResult;
	@FindBy(xpath="//span[@class='a-size-base-plus a-color-base a-text-normal' and contains(text(),'WristWidget® Adjustable Wrist Brace for TFCC Tears, One Size fits most. For Left and Right Wrists, Support for Weight Bearing Strain, Exercise')]") WebElement ProductSelection;
	@FindBy(xpath="//input[@id='add-to-cart-button']") WebElement AddToCart;
	@FindBy(xpath="//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']") WebElement CartItem;
	@FindBy(xpath="//input[@name='proceedToRetailCheckout']") WebElement Checkout;
	@FindBy(xpath="//input[@title='Place your order']") WebElement PlaceYourOrder;
	
   
	public GuestAccountPOM() {
		PageFactory.initElements(driver, this);	
	
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
	   
	   try {
		   PlaceYourOrder.click();
		   Thread.sleep(2000);
	   }
	   catch(Exception e){
		   
		String title= driver.getTitle();
		  if(title.contains("Place Your Order")) {
		  System.out.println(title);
		  Thread.sleep(2000);
		   }
		   else {
		   System.out.println(title);
		   Assert.assertTrue(title.contains("Place Your Order"));
		   }
	   }
	   
   
	   
   }









}