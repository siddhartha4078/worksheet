package com.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import library.Explicit_timeout;
import library.heighlight;

public class Worksheet_delete {

	public WebDriver driver;
	public heighlight h;
	public Explicit_timeout e;

	public Worksheet_delete(WebDriver dr) {
		this.driver = dr;
		h = new heighlight(driver);
		e = new Explicit_timeout(driver);
	}

	@FindBy(xpath = ".//*[@name='CultureId']")
	@CacheLookup
	WebElement Language_Dropdown;

	@FindBy(xpath = ".//*[@type='text']/following::input[2]" )
	@CacheLookup
	WebElement worksheet_textbox;
	
	
	

	@FindBy(xpath = "//a[contains(text(),'Search')]")
	@CacheLookup
	WebElement search_button;
	

	public void Enter_worksheetname(String worksheetname) {
		h.h(worksheet_textbox);
		worksheet_textbox.sendKeys(worksheetname);

	}

	public void select_culture(String culture) {
		h.h(Language_Dropdown);

		try {
			if (culture.equalsIgnoreCase(culture)) {

				Select s = new Select(Language_Dropdown);
				s.selectByVisibleText(culture);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void click_seachbutton(){
		h.h(search_button);
		search_button.click();
		
		
		
	}


}
