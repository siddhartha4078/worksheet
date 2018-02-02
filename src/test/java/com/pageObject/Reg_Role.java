package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import lib_methods.heighlight;

public class Reg_Role {

	public WebDriver driver;
	public heighlight h;

	public Reg_Role(WebDriver driver) {

		this.driver = driver;
		h = new heighlight(driver);
	}

	@FindBy(xpath = "//*[contains(text(),'Creat Your Free Account')]")
	@CacheLookup
	WebElement Confirm_rolepage;

	@FindBy(xpath = "//*[contains(text(),'I am Student')]")
	@CacheLookup
	WebElement student;

	@FindBy(xpath = "//*[contains(text(),'I am Teacher')]")
	@CacheLookup
	WebElement teacher;

	@FindBy(xpath = "//*[contains(text(),'I am Parent')]")
	@CacheLookup
	WebElement parent;

	public void confirmpage() {

		String exptext = "Creat Your Free Account";
		String actualtext = Confirm_rolepage.getText();
		Assert.assertEquals(actualtext, exptext);

	}

	public void click_iamstudent() {
		h.h(student);
		student.click();

	}

	public void click_iamparent() {
		h.h(parent);
		parent.click();

	}

	public void click_iamteacher() {
		h.h(teacher);
		teacher.click();

	}
}
