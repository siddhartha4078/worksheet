package Executed_Testcases;

import java.io.IOException;

import org.sikuli.script.FindFailed;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import config.Configuration;
import config.Configuration_grid;
import config.Configuration_hub;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import lib_methods.ExcelSheetDriver;

public class Solve_vedic_math extends Configuration_hub {
	public String data = "E:\\Siddhartha\\Projects\\Automation-neon\\com.worksheet\\src\\test\\resources\\TestData\\worksheetlist.xls";
	public ExcelSheetDriver excel;
	public ExcelSheetDriver ex;

	
	@BeforeSuite
	public void Openbrowser() throws InterruptedException {

		driver.get("https://uatmath2shine.azurewebsites.net/preuatWorksheetalpha");
		driver.manage().window().maximize();

		loginpage.Enter_credentials("siddhartha.student", "123456");
		loginpage.Click_loginbutton();
		Thread.sleep(3000);

		try {
			r = new ExtentReports("E:\\Siddhartha\\Projects\\Automation-neon\\com.worksheet\\report\\report.html");
			logger = r.startTest("Test initiated");
			log.tracelog("Test started");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void Login() throws InterruptedException {

		loginpage.Enter_credentials("live.student", "123456");
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
	
	@DataProvider(name = "Search data")
	public Object[][] passdata() throws BiffException, IOException {

		excel = new ExcelSheetDriver(data, "Vedicmathematics");

		int RowCount = ExcelSheetDriver.RowCount();

		Object[][] data = new Object[RowCount][4];

		for (int i = 0; i < RowCount; i++) {

			data[i][0] = ExcelSheetDriver.ReadCell(0, i);
			data[i][1] = ExcelSheetDriver.ReadCell(1, i);
			data[i][2] = ExcelSheetDriver.ReadCell(2, i);
			data[i][3] = ExcelSheetDriver.ReadCell(3, i);

		}

		return data;

	}

}
