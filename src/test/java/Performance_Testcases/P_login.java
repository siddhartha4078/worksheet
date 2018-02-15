package Performance_Testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.google.common.base.Stopwatch;

public class P_login extends  config.Configuration {
	public WebDriver driver;
	static double load;
	static String result;
	public Stopwatch pageLoad;
	static double v[];

	@Test
	public void Login() throws InterruptedException {
		
		String pass=pwd.encrypt_preuat();

		List<Double> result = new ArrayList();
		double v[] = new double[10];
		System.err.println("*****************Local******************");
		
		
		for (int i = 0; i < 10; i++) {

			loginpage.Enter_credentials("live.student", new String(pass));
			loginpage.Click_loginbutton();
			
		

			load = wp.Loadtime_login();
			Thread.sleep(2000);
			landingpage.logout();
			Thread.sleep(2000);

			result.add(load);

			int j = i + 1;

			v[i] = result.get(i);

			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " :" + j + "  "
					+ "response time" + " :" + v[i] + " " + "Sec");

		}

		double sum = Arrays.stream(v).sum();

		sum = sum / 10;

		String f = String.format("%.2f", sum);
		System.out.println();

		System.err.println("*********Average response time" + ":" + f + " " + "**********");

	}
}
