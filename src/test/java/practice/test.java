package practice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import library.Browser_factory;

public class test {
	public WebDriver driver;
	public Browser_factory b;
	String baseurl = "https://uatmath2shine.azurewebsites.net/WorksheetBundling/";


	
	public test(WebDriver drv){
		this.driver=drv;
		b = new Browser_factory();
		driver=b.initiate_browser("chrome");

		
	}

	@Test
	public void login() {
		driver.get(baseurl);

	}

}
