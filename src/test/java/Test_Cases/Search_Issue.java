package Test_Cases;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import config.Configuration;


public class Search_Issue extends Configuration {

	public void Login(String username) throws InterruptedException {

		loginpage.Enter_credentials(username, "123456");
		loginpage.Click_loginbutton();
	}

	public void Search(String worksheetname) {
		landingpage.search_worksheet(worksheetname);
		
		try {
			Alert a = driver.switchTo().alert();
		
			String alerttext = a.getText();
			System.out.println("Alert text is"+alerttext);
			a.accept();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		

	}

	public void verifyrecord() throws InterruptedException {

		landingpage.check_searchrecord();
		landingpage.logout();

	}

	@Test
	public void run_tc_search() throws InterruptedException {

		 
	
				Login("performance.test");
				Search("Money : add / subtract up to $1");
				Thread.sleep(3000);
				verifyrecord();
			
				
			}
		}

	


