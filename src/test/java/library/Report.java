package library;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Report {
	public static WebDriver driver;
	public ExtentReports r;
	public ExtentTest logger; 
	
	
	public Report(WebDriver dr){
		this.driver=dr;
		r= new ExtentReports("E:\\Siddhartha\\Projects\\Automation-neon\\com.worksheet_student\\reports\\report.html");
	}

	public void starttest(String startmsg){
		
		   logger =r.startTest(startmsg);	
	}
	public void info(String inf){
		
		 logger.log(LogStatus.INFO,inf);
		
	}
	public void pass(String message){
		
		 logger.log(LogStatus.PASS,message);
		
	}
	public void fail(String message){
		
		 logger.log(LogStatus.FAIL,message);
		 
		
	}
	
	public void screenshot_on_failure(String message,String path){
	logger.log(LogStatus.FAIL,message, logger.addScreenCapture(path));
		
		
	}
	
	
	
	public void enttest(){
		
		r.endTest(logger);
	    r.flush();
	}
	
	
}
