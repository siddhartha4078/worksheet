package Executed_Testcases;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import com.google.common.base.Stopwatch;

import config.Dataset;
import library.Sikuli_c;

public class Load_all_worksheets extends config.Configuration {
	public WebDriver driver;
	public double iteration1, iteration2, iteration3, avgs, Starttime1, Starttime2, Starttime3, start, avg2;
	public Stopwatch pageLoad;

	public void Login() throws InterruptedException {

		loginpage.Enter_credentials("live.student", "123456");
		loginpage.Click_loginbutton();
		Thread.sleep(3000);

	}

	public void click_on_image() throws InterruptedException {

		landingpage.click_on_bookandworksheet_hidder();
		Thread.sleep(2000);

	}

	public void click_on_assignmenttype(String a) throws InterruptedException {

		landingpage.Click_on_assignmenttype(a);
		Thread.sleep(3000);

	}

	public void click_on_book(String b) throws InterruptedException {

		landingpage.Click_on_book(b);
		Thread.sleep(3000);

	}

	public void click_on_chapter(String c) throws InterruptedException {

		landingpage.Click_on_chapter(c);

	}

	public void click_on_worksheet(String w) throws InterruptedException, FindFailed {

		for (int i = 1; i < 4; i++) {

			worksheetlistpage.Click_on_worksheet(w);

			if (i == 1) {
				worksheetstartpage.current_worksheetname();
			}

			System.out.println("Attempt no is --" + i + " " + "Started at---" + LocalTime.now());

			Thread.sleep(3000);

			worksheetstartpage.Start_worksheet();

			Thread.sleep(3000);
			generationpage.attempt_question(9);
			Thread.sleep(3000);
			generationpage.submit(0);
			double t = wp.scorepageLoadtime("Attempt Again");

			try {

				Scorepage.navigateback();

			} catch (StaleElementReferenceException e) {

				e.printStackTrace();
			}

			Thread.sleep(3000);

			while (i == 1) {

				iteration1 = t;

				System.out.println("scoretime is--" + "" + iteration1);

				break;
			}

			while (i == 2) {

				iteration2 = t;

				System.out.println("scoretime is--" + "" + iteration2);
				break;
			}

			while (i == 3) {

				iteration3 = t;
				System.out.println("scoretime is--" + "" + iteration3);
				sik.click_setM2Slogo();
				break;

			}

		}

	}

	public void calculate_avg() throws FindFailed {

		avg2 = (iteration2 + iteration3 + iteration1) / 3;

		System.err.println("Average score time is---" + "" + String.format("%.2f", avg2));

	}

	@Test
	public void rerun() throws IOException, InterruptedException, FindFailed {

		try {
			Login();
			for (Integer i = 0; i < 10; i++) {
				Dataset d = new Dataset();
				click_on_image();
				click_on_assignmenttype(d.assignmenttype(i));
				click_on_book(d.book(i));
				click_on_chapter(d.chapter(i));
				click_on_worksheet(d.worksheet(i));
				calculate_avg();

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
