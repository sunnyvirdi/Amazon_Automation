package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.POM.SearchPOM;
import com.amazon.base.BaseClass;

public class SearchTestCases extends BaseClass{
	
	public static SearchPOM search;
	
	public SearchTestCases() {
		super();
	}

	@BeforeMethod
	public void search() throws InterruptedException {
		initialization();
		search= new SearchPOM();
		search.mousehover();
		Thread.sleep(2000);
		search.EnterLogin();
		Thread.sleep(2000);
	}
		
	@Test(priority=1)
	public void sotirng() throws InterruptedException {
		search.search("nike hoodies for men");
		search.SortingHTL();
	}
	
	@Test(priority=2)
	public void sortfilter() throws InterruptedException{
	search.search("nike hoodies for men");
	search.SortingLTH();
	}
	@Test(priority=3)
	public void seachItem() throws InterruptedException {
		search.search("nike hoodies for men");
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Amazon.ca : nike hoodies for men");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		search.verifyimage();
		System.out.println("Image Displayed");
		Thread.sleep(2000);
		search.verifyname();
		System.out.println("Name Displayed");
		Thread.sleep(2000);
		search.verifyprice();
		System.out.println("Price Displayed");
		Thread.sleep(5000);
		search.navigatetonext();
		Thread.sleep(5000);
		search.navigatetoprev();
		Thread.sleep(2000);
		//driver.navigate().back();
		search.TotalItems();
		Thread.sleep(2000);
		search.pagination();
		
	}
	
	@Test(priority=4)
	public void partialitem() throws InterruptedException {
		search.search("B07RHZSW8");
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void CloseBrowser() {
		driver.quit();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
