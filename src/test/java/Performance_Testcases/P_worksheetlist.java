package Performance_Testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.google.common.base.Stopwatch;

public class P_worksheetlist extends config.Configuration {
	public WebDriver driver;
	static double load;
	static String result;
	public Stopwatch pageLoad;
	static double v[];

	@Test
	public void Worksheetlist() throws InterruptedException {

		List<Double> result = new ArrayList();
		double v[] = new double[10];

		loginpage.Enter_credentials("live.student", "123456");
		loginpage.Click_loginbutton();
		Thread.sleep(2000);
		landingpage.click_on_bookandworksheet_hidder();
		landingpage.Click_on_assignmenttype("Level 2");
		Thread.sleep(2000);
		landingpage.Click_on_book("Math Skills L2");
		Thread.sleep(2000);

		for (int i = 0; i < 10; i++) {

			landingpage.Click_on_chapter("Addition");

			double load = p.response();

			Thread.sleep(2000);

			Navigate.navigate_back();

			result.add(load);

			int j = i + 1;

			v[i] = result.get(i);

			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " :" + j + "  "
					+ "responce time" + " :" + v[i] + " " + "Sec");

		}

		double sum = Arrays.stream(v).sum();

		sum = sum / 10;

		String f = String.format("%.2f", sum);
		System.out.println();

		System.err.println("*********Average response time" + ":" + f + " " + "**********");

	}
}
