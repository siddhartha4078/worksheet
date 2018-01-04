package library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Implicit_timeout {
	public WebDriver driver;
	
	public  Implicit_timeout (WebDriver dr){
	this.driver = dr;
	}

	public void waitfor(int time){
		
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		
		
	}

}
