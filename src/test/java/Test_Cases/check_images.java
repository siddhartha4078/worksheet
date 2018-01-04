package Test_Cases;

import org.testng.annotations.Test;

public class check_images extends configuration.TestNg_Config {

	public void Login() throws InterruptedException {

		loginpage.Enter_credentials("performance.test", "123456");
		loginpage.Click_loginbutton();
		Thread.sleep(3000);
	}

	public void searchworksheet(String worksheetname) throws InterruptedException {
		landingpage.search_worksheet(worksheetname);

	}

	@Test
	public void run() throws InterruptedException {

		Login();

		searchworksheet("Halving of big numbers with decimal");

	}

}
