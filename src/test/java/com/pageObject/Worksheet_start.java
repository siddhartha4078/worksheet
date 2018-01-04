package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import library.heighlight;

public class Worksheet_start {

	public WebDriver driver;
	public heighlight h;

	public Worksheet_start(WebDriver dr) {
		this.driver = dr;
		h = new heighlight(driver);
	}

	@FindBy(css = "#hWorksheetName>span")
	WebElement WKname;

	@FindBy(css = ".btn.btn-math2shine.start-button")
	WebElement Startbutton;

	@FindBy(xpath = ".//*[contains(text(),'Video')]")
	@CacheLookup
	WebElement Youtubevideo;

	@FindBy(xpath = ".//*[contains(text(),'Overview')]")
	@CacheLookup
	WebElement overview;

	@FindBy(css = ".wrap")
	WebElement videoslider;

	public void Start_worksheet() {
		
		
		h.h(Startbutton);
		Startbutton.click();

	}
	
	public void current_worksheetname(){
		
		String Worksheetname = WKname.getText();
		
		System.err.println("Worksheet name  :"+Worksheetname);
	}

}
