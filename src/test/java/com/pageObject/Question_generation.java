package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import library.heighlight;

public class Question_generation {
	public WebDriver driver;
	public heighlight h;

	public Question_generation(WebDriver dr) {
		this.driver = dr;
		h = new heighlight(driver);
	}

	@FindBy(xpath = ".// *[@type='text']")
	@CacheLookup
	WebElement ansbox;
	
	
	@FindBy(xpath=".//*[@id='divTextBx']/img")
	@CacheLookup
	WebElement questionimage;

	@FindBy(xpath = ".//*[@id='btnStart']")
	WebElement submitbutton;

	public void enter_answer(String ans) {
		h.h(ansbox);
		ansbox.sendKeys(ans);
	}

	public void click_on_last_question() throws FindFailed {

		try {
			Screen s = new Screen();
			s.click("E:\\Siddhartha\\Projects\\Automation-neon\\com.worksheet\\sikuli\\lastquestion.png");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void submit() {
		try {
			h.h(submitbutton);
			submitbutton.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void click_on_questionnumber(int qno) {

		String questionno = ".//*[@id='" + qno + "']";

		WebElement question = driver.findElement(By.xpath(questionno));
		h.h(question);

		question.click();
	}

	public void img_submit() throws FindFailed {

		Screen s = new Screen();
		s.click("E:\\Siddhartha\\Projects\\Automation-neon\\com.worksheet\\src\\test\\resources\\Submit.png");
	}

}
