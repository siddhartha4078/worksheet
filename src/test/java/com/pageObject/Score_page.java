package com.pageObject;

import java.time.OffsetTime;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.sikuli.script.FindFailed;

import library.heighlight;

public class Score_page {
	public WebDriver driver;
	public heighlight h;
	public long second2;
	public OffsetTime offset;

	public Score_page(WebDriver dr) {
		this.driver = dr;
		h = new heighlight(driver);
		offset = OffsetTime.now();
	}

	@FindBy(xpath = ".//*[@id='tblWorksheetDetailstotPer']/tbody/tr[2]/td[1]")
	@CacheLookup
	WebElement Worksheettime;

	@FindBy(xpath = ".//*[@id='Backanchr']")
	@CacheLookup
	WebElement backbutton;

	@FindBy(css = "#divTextBx>img")
	@CacheLookup
	WebElement Questionimage;

	public void Worksheettime() {
		h.h(Worksheettime);
		String dateandtime = Worksheettime.getText();
		System.out.println("Worksheet start date and time is " + dateandtime);

	}

	public void back() throws FindFailed {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,950)", "");
			backbutton.click();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void navigateback() {
		
		WebElement link = driver.findElement(By.xpath(".//*[@id='spnNavigation']/span[5]/a"));
	
		Boolean b = link.isDisplayed();

		if (b) {

			h.h(link);
			link.click();

		}

		else {
			System.out.println("link not visible");
		}

	}

}
