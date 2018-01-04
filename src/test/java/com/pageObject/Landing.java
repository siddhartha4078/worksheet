package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;

import library.*;

public class Landing {
	public WebDriver driver;
	public heighlight h;
	public Explicit_timeout e;
	public Login l;

	public Landing(WebDriver dr) {
		this.driver = dr;
		h = new heighlight(driver);
		l = new Login(driver);

	}

	@FindBy(css = ".logotext")
	@CacheLookup
	WebElement logo;

	@FindBy(id = "cssmenu3")
	@CacheLookup
	WebElement classmenu;

	@FindBy(partialLinkText = "English")
	WebElement culturemenu;

	@FindBy(xpath = ".//*[contains(text(),'Hindi')]")
	@CacheLookup
	WebElement Hindiculture;

	@FindBy(xpath = ".//*[@id='dd']/li[1]/a")
	@CacheLookup
	WebElement Englishculture;

	@FindBy(css = "#img2")
	WebElement Bookandworksheet_hidder;

	@FindBy(css = "#imgSearchIcon")
	WebElement searchicon;

	@FindBy(css = "#txtSearchText")
	WebElement searchbox;

	@FindBy(css = "#btnSearch")
	WebElement searchbutton;

	@FindBy(xpath = "//*[contains(text(),'Clear')]")
	WebElement clearbutton;

	@FindBy(xpath = ".chapterUl>li>a")
	WebElement searchrecord;

	@FindBy(css = "#imgUserName")
	WebElement useriamge;

	@FindBy(css = "#logOutBtn")
	WebElement logout;
	
	
	@FindBy(partialLinkText = "Online")
	WebElement classname;
	
	@FindBy(css = ".chapterWrapper")
	WebElement search_result;
	
	
	
	
	


	public void Click_on_logo() {

		try {
			h.h(logo);
			logo.click();
		} catch (StaleElementReferenceException e) {
		
			e.printStackTrace();
		}
	}

	public void select_class(String cls) throws FindFailed {

		h.h(classmenu);

		Screen s = new Screen();
		s.click("\\sikuli\\Screenshot_1.png");

		String path = "//*[contains(text()," + "'" + cls + "'" + ")]";
		WebElement cl = driver.findElement(By.xpath(path));
		h.h(cl);
		cl.click();

	}

	public void Click_on_assignmenttype(String assignmenttype) {

		String path = "//*[contains(text()," + "'" + assignmenttype + "'" + ")]";
		WebElement b = driver.findElement(By.xpath(path));
		h.h(b);
		b.click();
	}

	public void Click_on_book(String book) {

		String path = "//*[contains(text()," + "'" + book + "'" + ")]";
		WebElement b = driver.findElement(By.xpath(path));
		h.h(b);
		b.click();
	}

	public void click_on_bookandworksheet_hidder() {

		e = new Explicit_timeout(driver);
		e.visibility(Bookandworksheet_hidder);

		h.h(Bookandworksheet_hidder);
		Bookandworksheet_hidder.click();
	}

	public void Click_on_chapter(String c) {

		String path = "//*[contains(text()," + "'" + c + "'" + ")]";
		WebElement sub = driver.findElement(By.xpath(path));
		h.h(sub);
		sub.click();
	}

	public void search_worksheet(String worksheetname) {

		e = new Explicit_timeout(driver);
		e.visibility(searchicon);

		h.h(searchicon);
		searchicon.click();

		h.h(searchbox);
		searchbox.sendKeys(worksheetname);
		h.h(searchbutton);
		searchbutton.click();

		

	}

	public void logout() throws InterruptedException {

		h.h(useriamge);
		useriamge.click();

		e = new Explicit_timeout(driver);
		e.visibility(logout);

		h.h(logout);
		logout.click();
		Thread.sleep(4000);

	}
	
	public void checkofdeaultclass(){
		
		String expected ="Online";
		
		String Actucal =  classname.getText();
		
		
		Assert.assertEquals(Actucal, expected, "Not default class");
		
		
	}
	
	public void check_searchrecord(){
		
		h.h(search_result);
		
		
		
		boolean display =search_result.isDisplayed();
		
		if (display){
			
			System.out.println("Search operation succesfull");
			
		}
			else{
				
				System.err.println("Search operation failed");
				
				
			}
			
			
		}
		
		
		
	}


