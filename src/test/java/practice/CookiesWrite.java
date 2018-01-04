package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.StringTokenizer;
import java.io.BufferedReader;		
import java.io.File;		
import java.io.FileReader;		
import java.util.Date;		
import java.util.StringTokenizer;		
import org.openqa.selenium.Cookie;		
import org.openqa.selenium.WebDriver;		

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import configuration.TestNg_Config;

public class CookiesWrite extends TestNg_Config {

	public WebDriver driver;

	@Test
	public void getcookies() throws InterruptedException {

		loginpage.Enter_credentials("performance.test", "123456");
		loginpage.Click_loginbutton();
		// Thread.sleep(4000);
		// landingpage.logout();

		File file = new File("Cookies.data");

		try {

			file.delete();
			file.createNewFile();

			FileWriter fileWrite = new FileWriter(file);
			BufferedWriter Bwrite = new BufferedWriter(fileWrite);
			for (Cookie ck : driver.manage().getCookies()) {
				Bwrite.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";"
						+ ck.getExpiry() + ";" + ck.isSecure()));
				Bwrite.newLine();
			}
			Bwrite.close();
			fileWrite.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
