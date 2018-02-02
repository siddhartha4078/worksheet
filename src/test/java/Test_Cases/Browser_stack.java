package Test_Cases;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import com.google.common.base.Stopwatch;

import config.Browserstack;

public class Browser_stack extends Browserstack {

	public Browser_stack() throws MalformedURLException {
		super();
		
	}

	public WebDriver driver;

	@Test(priority = 1)
	public void login() throws InterruptedException {

		

	}

}
