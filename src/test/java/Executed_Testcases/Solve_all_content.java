package Executed_Testcases;

import java.io.IOException;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;


import config.Configuration;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Solve_all_content extends Configuration {

	public void Login() throws InterruptedException {

		loginpage.Enter_credentials("siddhartha.student", "123456");
		loginpage.Click_loginbutton();
		Thread.sleep(3000);
	}

	public void click_on_image() throws InterruptedException {

		landingpage.click_on_bookandworksheet_hidder();

	}

	public void click_on_assignmenttype(String a) throws InterruptedException {

		landingpage.Click_on_assignmenttype(a);
		Thread.sleep(2000);

	}

	public void click_on_book(String b) throws InterruptedException {

		landingpage.Click_on_book(b);
		Thread.sleep(2000);

	}

	public void click_on_chapter(String c) throws InterruptedException {

		landingpage.Click_on_chapter(c);

	}

	public String click_on_worksheet(String w)
			throws InterruptedException, FindFailed, RowsExceededException, WriteException, IOException, BiffException {

		worksheetlistpage.Click_on_worksheet(w);

		String Worksheetname =worksheetstartpage.current_worksheetname();
		
		System.err.println("Worksheet name  :"+Worksheetname);

		worksheetstartpage.Start_worksheet();
		wait.waitfor(3);
		generationpage.solve_all();
		
		return Worksheetname;

	}

	public void verfiy_scorepage() throws InterruptedException, FindFailed {
		wait.waitfor(5);

		Scorepage.back();

		wait.waitfor(5);

		landingpage.verify_landingpage();
	}

	@Test(dataProvider = "Search data")
	public void RunTest(String Assignemttype, String Bookname, String chaptername, String worksheetname)
			throws IOException, InterruptedException, FindFailed, RowsExceededException, WriteException, BiffException {
	
		click_on_image();
		click_on_assignmenttype(Assignemttype);
		click_on_book(Bookname);
		click_on_chapter(chaptername);
		click_on_worksheet(worksheetname);

	}

}
