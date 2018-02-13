package Performance_Testcases_grid;

import java.io.IOException;
import java.time.LocalTime;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import lib_methods.*;

import com.google.common.base.Stopwatch;

import jxl.read.biff.BiffException;

public class G_P_Scorepage extends config.Configuration_grid2 {
	public WebDriver driver;
	public double iteration1, iteration2, iteration3, avgs, Starttime1, Starttime2, Starttime3, start, avg2;
	public Stopwatch pageLoad;
	private String excelpath = "E:\\Siddhartha\\Projects\\Automation-neon\\com.worksheet\\src\\test\\resources\\TestData\\worksheetlist.xls";
	private String sheetname = "Testdata";

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
				String wkname = worksheetstartpage.current_worksheetname();
				System.err.println("Current worksheet:" + " " + wkname);
				
				System.out.println();
			}

			System.out.println("Attempt:" + i + " " + "******" + "Started at" + "-" + LocalTime.now());

			Thread.sleep(3000);

			worksheetstartpage.Start_worksheet();
			int k = generationpage.check_questioncount();

			Thread.sleep(3000);
			generationpage.attempt_question(9);
			Thread.sleep(3000);
			generationpage.submit();
			double t = p.response();

			try {

				Scorepage.navigateback();

			} catch (StaleElementReferenceException e) {

				e.printStackTrace();
			}

			Thread.sleep(3000);

			while (i == 1) {

				iteration1 = t;

				System.out.println("scoretime is--" + "" + iteration1);
				System.out.println();

				break;
			}

			while (i == 2) {

				iteration2 = t;

				System.out.println("scoretime is--" + "" + iteration2);
				System.out.println();

				break;
			}

			while (i == 3) {

				iteration3 = t;
				System.out.println("scoretime is--" + "" + iteration3);
				System.out.println();

				landingpage.navigate_to_landing();
				break;

			}

		}

	}

	public void calculate_avg() throws FindFailed {

		avg2 = (iteration2 + iteration3 + iteration1) / 3;

		System.err.println("Average score time is---" + "" + String.format("%.2f", avg2));
		System.out.println("--------------------------------------------");

	}
	
	@Test(priority=1)
	public void Login() throws InterruptedException {

		loginpage.Enter_credentials("live.student", "123456");
		loginpage.Click_loginbutton();
		Thread.sleep(3000);

	}


	@Test(dataProvider = "Search data",priority=2)
	public void TEST(String a, String b, String c, String w) throws IOException, InterruptedException, FindFailed {

		try {
			
			click_on_image();
			click_on_assignmenttype(a);
			click_on_book(b);
			click_on_chapter(c);
			click_on_worksheet(w);
			calculate_avg();

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
