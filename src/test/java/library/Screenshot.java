package library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;

public class Screenshot {

	public WebDriver driver;

	

	public Screenshot(WebDriver drv) {
		this.driver = drv;

	}

	public String  Capturescreenshot(WebDriver driver,String Screenshotname) throws IOException {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File sc = ts.getScreenshotAs(OutputType.FILE);
			
			String dest="E:\\Siddhartha\\Projects\\Automation-neon\\com.worksheet\\screenshot\\"+Screenshotname+".jpeg";
					
			FileUtils.copyFile(sc, new File(dest));
		
	
			
			return dest;
			
			
		} 
		catch (Exception e) {
			System.out.println("exception while taking screenshot"+e.getMessage());
			return e.getMessage();
		}
		

	}
	
	
		
		
		
		
	}


