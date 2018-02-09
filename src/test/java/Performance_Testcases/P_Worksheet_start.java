package Performance_Testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import lib_methods.*;

import com.google.common.base.Stopwatch;

import jxl.read.biff.BiffException;

public class P_Worksheet_start extends config.Configuration {
	public WebDriver driver;
	static double load;
	public Stopwatch pageLoad;
	private String excelpath = "E:\\Siddhartha\\Projects\\Automation-neon\\com.worksheet\\src\\test\\resources\\TestData\\worksheetlist.xls";
	private String sheetname = "Testdata";
	static List<Double> result;

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

	public double click_on_worksheet(String w) throws InterruptedException, FindFailed {

		worksheetlistpage.Click_on_worksheet(w);

		String Worksheetname = worksheetstartpage.current_worksheetname();

		worksheetstartpage.Start_worksheet();

		double load = p.response();

		System.out.println("Worksheet name"+" : "+Worksheetname);
		
		System.err.println("response time" + " :" + load + " " + "Sec");

		System.out.println("*************************************");
		
		Thread.sleep(2000);
	

		return load;

	}

	public void navigate_back() throws InterruptedException {
		Navigate.navigate_to(
				"https://uatmath2shine.azurewebsites.net/PreuatWorksheetAlpha/Student/StudentHome/Landing");
		Thread.sleep(2000);

	}

	@Test(priority = 1)
	public void Login() throws InterruptedException {

		loginpage.Enter_credentials("live.student", "123456");
		loginpage.Click_loginbutton();
		Thread.sleep(3000);

	}

	@Test(dataProvider = "Search data", priority = 2)
	public void TEST(String a, String b, String c, String w) throws IOException, InterruptedException, FindFailed {

		try {
			click_on_image();
			click_on_assignmenttype(a);
			click_on_book(b);
			click_on_chapter(c);
			click_on_worksheet(w);
			Thread.sleep(2000);
			navigate_back();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@DataProvider(name = "Search data")
	public Object[][] testdata() throws BiffException, IOException {

		ExcelSheetDriver e = new ExcelSheetDriver(excelpath, sheetname);

		int rowc = e.RowCount();

		Object[][] data = new Object[rowc][4];

		for (int i = 0; i < rowc; i++) {

			data[i][0] = ExcelSheetDriver.ReadCell(0, i);
			data[i][1] = ExcelSheetDriver.ReadCell(1, i);
			data[i][2] = ExcelSheetDriver.ReadCell(2, i);
			data[i][3] = ExcelSheetDriver.ReadCell(3, i);

		}

		return data;

	}

}
