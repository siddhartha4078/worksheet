package com.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import lib_methods.*;

public class Login {
	public WebDriver driver;
	public heighlight h;
	public Explicit_timeout e;

	public Login(WebDriver dr) {
		this.driver = dr;
		h = new heighlight(driver);
	}

	@FindBy(name = "UserName")
	@CacheLookup
	WebElement logInUserName;

	@FindBy(name = "Password")
	@CacheLookup
	WebElement logInPassword;

	@FindBy(css = ".btn.btn-primary")
	@CacheLookup
	WebElement logInButton;

	@FindBy(css = "input[type='checkbox']")
	@CacheLookup
	WebElement rememberMeCheck;

	@FindBy(partialLinkText = "Forgot Password?")
	WebElement forgotPasswordLink;

	@FindBy(xpath = "//*[contains(text(),'Login with your Math2shine account!')]")
	@CacheLookup
	WebElement logpagetext;

	@FindBy(xpath = "//*[contains(text(),'Sign Up Now')]")
	@CacheLookup
	WebElement signup_button;

	public void Enter_credentials(String uname, String paswd) {
		h.h(logInUserName);
		logInUserName.sendKeys(uname);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		h.h(logInPassword);
		logInPassword.sendKeys(paswd);
	}

	public void Click_loginbutton() {

		h.h(logInButton);
		logInButton.click();
	}

	public void verify_loginpage() {
		String Expected = "Login with your Math2shine account!";

		String text;
		try {
			e = new Explicit_timeout(driver);
			e.visibility(logpagetext);

			h.h(logpagetext);
			text = logpagetext.getText();

			if (text.equals(Expected)) {

				System.out.println("Succesfully logged out");
			} else {
				System.out.println("Not logged out");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void click_singup_button() {
		h.h(signup_button);
		signup_button.click();

	}

	public String login_without_credentails() {

		h.h(logInUserName);
		logInUserName.sendKeys("");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		h.h(logInPassword);
		logInPassword.sendKeys("");

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		h.h(logInButton);
		logInButton.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		Alert a = driver.switchTo().alert();
		
		System.out.println(a);
		
		
		return null;
	}

}
