package library;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class heighlight {
	
	public WebDriver driver;

	
	public heighlight (WebDriver drv){
		this.driver=drv;
	}
	
	public void h(WebElement ele){
		
	    try {
			JavascriptExecutor js=(JavascriptExecutor)driver; 
			js.executeScript("arguments[0].style='border:3px solid red;background: #6A755C;' ", ele);
			
			
			try {
				Thread.sleep(2000);	
			}
			catch(Exception e){
			System.out.println(e.getMessage());
			}
			
			js.executeScript("arguments[0].style='border:none;background: ;' ", ele);
		} catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
