package com.amazon.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.amazon.base.BaseClass;

public class ShoppingPOM extends BaseClass{
	@FindBy(xpath="//a[@id='nav-link-accountList']") WebElement AccountList;
	@FindBy(xpath="//span[@class='nav-action-inner' and contains(text(),'Sign in')]") WebElement Sign_in;
	@FindBy(id="ap_email") WebElement email_Address;
	@FindBy(xpath="//input[@class='a-button-input']") WebElement continuebtn;
	@FindBy(xpath="//input[@id='ap_password']") WebElement password;
	@FindBy(xpath="//input[@id='signInSubmit']") WebElement SignInbtn;
	@FindBy(xpath="//input[@id='twotabsearchtextbox']") WebElement SearchField;
	@FindBy(xpath="//input[@id='nav-search-submit-button']") WebElement Searchbtn;
	@FindBy(xpath="//span[@class='a-color-state a-text-bold']") WebElement SearchResult;
	@FindBy(xpath="//span[text()='Microsoft Surface Laptop Go 12.4in Touchscreen Intel i5 (Renewed)']") WebElement ItemSelected;
	@FindBy(xpath="//input[@id='add-to-cart-button']") WebElement AddToCart;
	@FindBy(xpath="//input[@aria-labelledby='attachSiNoCoverage-announce']	") WebElement NoCoverage;
	@FindBy(xpath="//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']") WebElement ItemAdded;
	@FindBy(id="nav-cart") WebElement Cart;
	@FindBy(xpath="//a[@class='a-button-text']") WebElement GoToCart;
	@FindBy(xpath="//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-mini sc-info-block']") WebElement ItemInfo;
	@FindBy(xpath="//select[@name='quantity']") WebElement SelectBox;
	@FindBy(xpath="//div[@class='a-row a-spacing-mini sc-subtotal sc-subtotal-activecart sc-java-remote-feature']") WebElement SubTotal;
	@FindBy(xpath="//span[text()='Wrist Brace Compression Wraps Sleeve Support for Arthritis and Tendinitis Pain Relief, Fitness, Weightlifting | Wrist Pain Relief, Adjustable']")   WebElement AnotherItem;
	@FindBy(xpath="//span[text()='Wrist Brace Compression Wraps Sleeve Support for Arthritis an…']") WebElement WristItemInfo;
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[3]/div[4]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[2]/span[1]/input[1]") WebElement Delete2;
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[3]/div[4]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[2]/span[1]/input[1]") WebElement Delete;
	@FindBy(xpath="//h1[@class='a-spacing-mini a-spacing-top-base']") WebElement EmptyCart;
	
	public ShoppingPOM() {
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
		SearchField.sendKeys(prop.getProperty("ShoppingProduct"));
		Searchbtn.click();
	
	}

	
	 public void SearchItem() { 
	 String actual=driver.getTitle();
	 Assert.assertEquals(actual, "Amazon.ca : laptop");
	 System.out.println(actual); 
	 }
	 
	public void SearchSelection() throws InterruptedException {
		ItemSelected.click();
		AddToCart.click();
		Thread.sleep(2000);
		NoCoverage.click();
	}

	public void SearchAnotherItem() throws InterruptedException {
		SearchField.click();
		SearchField.sendKeys(prop.getProperty("SearchProduct"));
		Searchbtn.click();
		Thread.sleep(2000);
		
	}
	public void SelectItem() throws InterruptedException {
		AnotherItem.click();
		Thread.sleep(2000);
		AddToCart.click();
		
	}

	
	
   public void CartItem() {
	   String Actual= ItemAdded.getText();
	   String Expected= "Added to Cart";
	   Assert.assertEquals(Actual, Expected);
	   System.out.println(Actual);
   }
   public void clickOnCart() {
	   Cart.click();
	   
   } 
   
   public void quantity() throws InterruptedException {
	   Select obj=new Select(SelectBox);
	   obj.selectByVisibleText("2");
	   Thread.sleep(5000);
	   String actual= SubTotal.getText();
	   Assert.assertTrue(actual.contains("Subtotal (2 items): $1,198.00"));
	   System.out.println(actual);
   }
   
   
   public void AddAnotherItem() {
	   AnotherItem.click();
   }
   
   public void VerifyCart() {
	   String actual = SubTotal.getText();
		Assert.assertTrue(actual.contains("Subtotal (3 items): $1,207.99"));
		System.out.println(actual);
   }
   
   public void deleteWristSupport() {
	   Delete2.click();
		String actual= SubTotal.getText();
		Assert.assertTrue(actual.contains("Subtotal (2 items): $1,198.00"));
		System.out.println(actual);
   }
   public void deleteall() {
	   	Delete.click();
		String actual= SubTotal.getText();
		Assert.assertTrue(actual.contains("Subtotal (0 items):"));
		System.out.println(actual);
		boolean result = EmptyCart.isDisplayed();
		System.out.println(EmptyCart.getText());
   }
   
   
   
   
   
   
}