package Test_Cases;

import java.net.MalformedURLException;

import org.testng.annotations.Test;


import config.Configuration;


public class check_images extends Configuration {



	public void Login() throws InterruptedException {

		loginpage.Enter_credentials("siddhartha.student", "123456");
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
