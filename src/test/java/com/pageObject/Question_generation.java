package com.pageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import config.Configuration_hub;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import lib_methods.ExcelSheetDriver;
import lib_methods.Implicit_timeout;
import lib_methods.heighlight;

public class Question_generation {
	public ExtentReports r;
	public ExtentTest logger;
	public WebDriver driver;
	public heighlight h;
	public Worksheet_start ws;
	public int Questionnumber;
	public WebElement submit2;
	public WebElement submit;
	public Implicit_timeout t;
	public String scorepageurl = "https://uatmath2shine.azurewebsites.net/PreuatWorksheetAlpha/Student/StudentHome/WorksheetScore";
	public String landingurl = "https://uatmath2shine.azurewebsites.net/PreuatWorksheetAlpha/Student/StudentHome/Landing";
	public ExcelSheetDriver e;
	public String excelpath = "E:\\Siddhartha\\Projects\\Automation-neon\\com.worksheet\\src\\test\\resources\\testoutput.xls";
	public String sheetname = "sheet1";
	public int qc;

	public Question_generation(WebDriver dr) throws BiffException, IOException {
		this.driver = dr;
		h = new heighlight(driver);
		t = new Implicit_timeout(driver);
		ws = new Worksheet_start(driver);

	}

	@FindBy(xpath = ".// *[@type='text']")
	@CacheLookup
	WebElement ansbox;

	@FindBy(xpath = ".//*[@id='divTextBx']/img")
	@CacheLookup
	WebElement questionimage;

	@FindBy(id = "btnStart")
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
			WebElement submit2 = driver.findElement(By.id("btnStart"));

			h.h(submit2);

			submit2.click();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public int Active_questionnumber() {
		WebElement activequestion = driver.findElement(By.className("linkActive"));
		String id = activequestion.getAttribute("id");

		qc = Integer.parseInt(id);
		qc = qc + 1;
		System.out.println("Active question number is:" + "" + qc);
		t.waitfor(1);

		return Questionnumber;
	}

	public void attempt_question(int qno) {

		String questionno = ".//*[@id='" + qno + "']";
		WebElement question = driver.findElement(By.xpath(questionno));
		String qn = question.getText();
		question.click();

	}

	public void img_submit() throws FindFailed {

		Screen s = new Screen();
		s.click("E:\\Siddhartha\\Projects\\Automation-neon\\com.worksheet\\src\\test\\resources\\Submit.png");
	}

	public boolean check_questionsubmit(int i)
			throws InterruptedException, IOException, RowsExceededException, WriteException, BiffException {
		Thread.sleep(7000);

		String act = "linkActive";
		String dact = "linkDisebled";

		List<WebElement> Qc = driver.findElements(By.xpath(".//*[@class='overview']/li"));
		int Questionnumber2 = Qc.size();

		if (i == 0) {

			WebElement submit2 = driver.findElement(By.name("submitanswer"));
			Boolean submitbuttondisplayed = submit2.isDisplayed();

			WebElement activequestion = driver.findElement(By.className("linkActive"));
			String id = activequestion.getAttribute("id");
			int q = Integer.parseInt(id);

			String link = activequestion.getAttribute("class");
			boolean isactive = link.equalsIgnoreCase(act);

			if (isactive == true && submitbuttondisplayed) {

				WebElement submit3 = driver.findElement(By.id("btnStart"));
				h.h(submit3);
				submit3.click();

				return true;

			} else if (isactive == false && submitbuttondisplayed == false) {
				t.waitfor(3);

				System.out.println("Question page did not appeared");

				return false;

			} else {
				return false;
			}

		} else if (i < Questionnumber2) {

			WebElement submit2 = driver.findElement(By.name("submitanswer"));
			Boolean submitbuttondisplayed = submit2.isDisplayed();

			int iprev = i - 1;
			int inext = i;

			String ipr = String.valueOf(iprev);
			String ipn = String.valueOf(inext);

			WebElement lastqustion = driver.findElement(By.id(ipr));
			String lastq = lastqustion.getAttribute("class");
			boolean deactive = lastq.equalsIgnoreCase(dact);

			if (deactive == true && submitbuttondisplayed) {

				System.out.println("question number " + "" + i + " " + ":is solved");
				WebElement submit3 = driver.findElement(By.id("btnStart"));
				h.h(submit3);
				submit3.click();

				return true;

			}

			else if (deactive == false && submitbuttondisplayed) {

				System.out.println("Error verified error is question number:" + "" + i);
				WebElement submit3 = driver.findElement(By.id("btnStart"));
				h.h(submit3);
				submit3.click();
				return true;

			} else if (deactive == true && submitbuttondisplayed == false) {

				driver.findElement(By.id("timearrow")).click();

				String wkname = driver.findElement(By.id("lbl")).getText();

				String e1 = "Error in--" + "" + wkname + " ." + " question number:" + "" + i;

				System.err.println("Error in--" + "" + wkname + " ." + " question number:" + "" + i);
				logger.log(LogStatus.FAIL, e1);

				if (i < Questionnumber2 - 1) {

					try {

						WebElement nextq = driver.findElement(By.id(ipn));
						h.h(nextq);
						nextq.click();
						check_questionsubmit(i);

					} catch (Exception e) {

						e.printStackTrace();
					}
				}

				driver.navigate().to(landingurl);

				return false;

			} else {
				return false;
			}

		} else {

			String currenturl = driver.getCurrentUrl();
			String expurl = "/WorksheetScore";
			if (currenturl.contains(expurl)) {
				System.out.println("question number " + "" + i + " " + ":is solved");
				driver.navigate().to(landingurl);
				System.out.println("---------Trying to solve next question !!!!!!!! ------------");

				return true;
			} else {
				return false;
			}

		}

	}

	public int check_questioncount() {

		List<WebElement> Qc = driver.findElements(By.xpath(".//*[@class='overview']/li"));
		Questionnumber = Qc.size();

		System.out.println("Question count for this worksheet is : " + Questionnumber);
		return Questionnumber;
	}

	public void solve_all()
			throws FindFailed, InterruptedException, RowsExceededException, WriteException, IOException, BiffException {
		check_questioncount();
		System.out.println("Question count for this worksheet is :" + Questionnumber);

		for (int i = 0; i <= Questionnumber; i++) {
			try {

				boolean a = check_questionsubmit(i);
				if (a == true) {

					System.out.println("---------------------");
					t.waitfor(5);
					if (i == Questionnumber) {

					}

				} else {
					System.out.println("---------Trying to solve next question !!!!!!!! ------------");
					break;
				}
			} catch (StaleElementReferenceException e) {
				System.out.println(e.getMessage());

			}
		}

	}

}
