package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import lib_methods.*;

public class Worksheet_list {

	public WebDriver driver;
	public heighlight h;
	public Wait_for_pageload wp;
	public Scroll s;
	public Explicit_timeout t;
	public WebElement Attemptcount;

	public Worksheet_list(WebDriver dr) {
		this.driver = dr;
		h = new heighlight(driver);
		wp = new Wait_for_pageload(driver);
		s = new Scroll(driver);
		t = new Explicit_timeout(driver);

	}

	public void Click_on_worksheet(String w) {

		String path = "//*[contains(text()," + "'" + w + "'" + ")]";
		WebElement ws = driver.findElement(By.xpath(path));
		h.h(ws);
		ws.click();

	}

	public void check_attempts() {

		try {

			s.scroll_down(1000);

			Attemptcount = driver.findElement(By.cssSelector(".worksheetheading>span>a"));
			t.visibility(Attemptcount);
			h.h(Attemptcount);
			String attempts = Attemptcount.getText();
			System.out.println("Current attempt is----- " + attempts);

			s.scroll_up(-1000);
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
