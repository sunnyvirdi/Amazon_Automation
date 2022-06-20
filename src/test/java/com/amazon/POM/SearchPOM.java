package com.amazon.POM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.amazon.base.BaseClass;

public class SearchPOM extends BaseClass{
	
	@FindBy(xpath="//a[@id='nav-link-accountList']") WebElement AccountList;
	@FindBy(xpath="//span[@class='nav-action-inner' and contains(text(),'Sign in')]") WebElement Sign_in;
	@FindBy(id="ap_email") WebElement email_Address;
	@FindBy(xpath="//input[@class='a-button-input']") WebElement continuebtn;
	@FindBy(xpath="//input[@id='ap_password']") WebElement password;
	@FindBy(xpath="//input[@id='signInSubmit']") WebElement SignInbtn;
	@FindBy(id="twotabsearchtextbox") WebElement Search;
	@FindBy(id="nav-search-submit-button") WebElement submit;
	@FindBy(xpath="//span[contains(text(),'nike')]") WebElement AssertElement;
	@FindBy(xpath="//img[@alt='Nike Mens Pullover Fleece Hoodie']") WebElement Image;
	@FindBy(xpath="//span[text()='Mens Pullover Fleece Hoodie']") WebElement SelectProduct;
	@FindBy(xpath="//i//span[text()='4.7 out of 5']") WebElement ProductRating;
	@FindBy(xpath="//span[@class='a-price-fraction' and contains(text(),'59')]") WebElement ProductPrice;
	@FindBy(linkText="Next") WebElement next;
	@FindBy(linkText="Previous") WebElement previous;
	@FindBy(xpath="//span[@class='s-pagination-item s-pagination-selected' and @aria-label='Current page, page 1']") WebElement Page1;
	@FindBy(xpath="//span[@class='s-pagination-item s-pagination-selected' and @aria-label='Current page, page 2']") WebElement Page2;
	@FindBy(xpath="//div[@class='s-card-container s-overflow-hidden aok-relative s-expand-height s-include-content-margin s-latency-cf-section s-card-border']") WebElement TotlaItem;
	
	    public SearchPOM() {
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
	
	    public void assert1() {
		String actual= AssertElement.getText();
		Assert.assertTrue(actual.contains("nike"));
		System.out.println(actual);
	    }
	
	    public void search(String name) {
		Search.sendKeys(name);
		submit.click();	;
	    }
	    public boolean verifyimage() {
		boolean result=Image.isDisplayed();
		return result;
		
	    }
	    public boolean verifyname() {
		boolean result=SelectProduct.isDisplayed();
		return result;
		
	    }
	    public boolean verifyrating() {
		boolean result = ProductRating.isDisplayed();
		return result;
	    }
	    public boolean verifyprice() {
		boolean result= ProductPrice.isDisplayed();
		return result;
	    }
	
	    public boolean navigatetonext() throws InterruptedException {
	
		next.click();
		Thread.sleep(5000);
		boolean result=Page2.isDisplayed();
	    return result;
	    }
	    public boolean navigatetoprev() throws InterruptedException {
		

		previous.click();
		Thread.sleep(5000);
		boolean result=Page1.isDisplayed();
		return result;

	   }
	
	    public void TotalItems() {
		int TotalItems=driver.findElements(By.xpath("//div[@class='s-card-container s-overflow-hidden aok-relative s-expand-height s-include-content-margin s-latency-cf-section s-card-border']")).size();
		Assert.assertEquals(TotalItems, 60);
		System.out.println(TotalItems);
	     }
	    public void pagination() throws InterruptedException {
		 List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		WebElement Nextbutton= driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
		List<String> Totalitems= new ArrayList<String>();
		
		for( WebElement item:list) {	 
		 Totalitems.add(item.getText());	 
		 System.out.println(item.getText()); 
		 }
	
	     while(true) {
		 
		 Thread.sleep(3000);
		 Nextbutton.click();
		 Thread.sleep(5000);
		        //base.Baseclass_amazon.Javaexecutor(2000);
		 list = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		       
		 for( WebElement item:list) {
		       
		 String Actual= item.getText();
		 Totalitems.add(Actual);
		  	   
		 
		   
		 if(!(Actual.equals("nike hoodies for men"))) {
		 continue;
		 }
		 else {
		   
		 Assert.assertNotSame(Actual, "nike hoodies for men", "Items can not be repeated");
		   
		 } }

		 System.out.println("*********************");
		 try {
		 Nextbutton= driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
		       
		        }
		 catch(Exception e) {
		 System.out.println("No more product left");
		 break;
		}
		        }
	 
	
	 }
	
	public void SortingLTH() throws InterruptedException {

	List<WebElement> beforeFilter= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	List<Double> beforefilterprice =new ArrayList<Double>();
		
	for(WebElement p: beforeFilter) {
	beforefilterprice.add(Double.valueOf(p.getText().replace("$", "")));
		
		}
	System.out.println(beforefilterprice);
	Select obj=new Select(driver.findElement(By.id("s-result-sort-select")));
	obj.selectByVisibleText("Price: Low to High");
	List<WebElement> afterFilter= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	List<Double> afterfilterprice =new ArrayList<Double>();
	for(WebElement q: afterFilter) {
	Thread.sleep(5000);
		
	afterfilterprice.add(Double.valueOf(q.getText().replace("$", ""))) ;
		
	}
	System.out.println("Before"+ afterfilterprice);
		
	Collections.sort(afterfilterprice,Collections.reverseOrder());
	System.out.println("After" + afterfilterprice);
	Assert.assertNotEquals(afterfilterprice, beforefilterprice);
		
	}
		

	 public void SortingHTL() throws InterruptedException {
		    		
	  List<WebElement> beforeFilter= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	  List<Double> beforefilterprice =new ArrayList<Double>();
		    		
	  for(WebElement p: beforeFilter) {
	  beforefilterprice.add(Double.valueOf(p.getText().replace("$", "")));
		    		
	   }
	  System.out.println(beforefilterprice);
	  Select obj=new Select(driver.findElement(By.id("s-result-sort-select")));
	  obj.selectByVisibleText("Price: High to Low");
	  List<WebElement> afterFilter= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	  List<Double> afterfilterprice =new ArrayList<Double>();
		    		
	  for(WebElement q: afterFilter) {
	  Thread.sleep(2000);
		    		
	  afterfilterprice.add(Double.valueOf(q.getText().replace("$", ""))) ;
		    		
	  }
	  System.out.println("Before"+ afterfilterprice);
	  Collections.sort(afterfilterprice,Collections.reverseOrder());
	  System.out.println("After" + afterfilterprice);
	  Assert.assertNotEquals(afterfilterprice, beforefilterprice);
		    		
	  }}
