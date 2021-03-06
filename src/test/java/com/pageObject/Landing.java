package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;

import lib_methods.*;

public class Landing {
	public WebDriver driver;
	public heighlight h;
	public Explicit_timeout e;
	public Login l;
	private String url = "https://uatmath2shine.azurewebsites.net/UatWorksheetAlpha/Student/StudentHome/Landing";
	public WebElement b;
	public String landingurl = "https://uatmath2shine.azurewebsites.net/PreuatWorksheetAlpha/Student/StudentHome/Landing";

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

	public void verify_landingpage() {

		Assert.assertEquals(driver.getCurrentUrl(), url, "Landing page not loaded");

		System.out.println("Landing page succesfully loaded");

	}

	public void Click_on_logo() {

		try {
			System.out.println("Redirecting to ladning page");
			h.h(logo);
			logo.click();

			String acturl = "https://uatmath2shine.azurewebsites.net/PreuatWorksheetAlpha/Student/StudentHome/Landing";
			String expurl = driver.getCurrentUrl();

			Assert.assertEquals(acturl, expurl, "Redirection fail");

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

		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("MenuAssignmentType"))));

	}

	public void Click_on_chapter(String c) {

		String path = "//*[contains(text()," + "'" + c + "'" + ")]";
		WebElement sub = driver.findElement(By.xpath(path));
		h.h(sub);
		sub.click();
		
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("spnNavigation"))));
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

		h.h(searchbox);
		searchbox.clear();

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

	public void checkofdeaultclass() {

		String expected = "Online";

		String Actucal = classname.getText();

		Assert.assertEquals(Actucal, expected, "Not default class");

	}

	public void check_searchrecord() {

		h.h(search_result);

		boolean display = search_result.isDisplayed();

		if (display) {

			System.out.println("Search operation succesfull");

		} else {

			System.err.println("Search operation failed");

		}

	
		}
	public boolean navigate_to_landing() {

		driver.navigate().to(landingurl);
		return false;
	}

}
