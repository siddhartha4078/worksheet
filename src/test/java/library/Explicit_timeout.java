package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Explicit_timeout {
	
	public WebDriver driver;
	
	public Explicit_timeout(WebDriver drv){
		this.driver=drv;
		
		
	}

	public void visibility(WebElement ele) {
		
	    WebDriverWait w = new WebDriverWait(driver,30);
	    WebElement el =w.until(ExpectedConditions.visibilityOf(ele));
	
	}
	

      public void clickable(WebElement ele){ 
	    WebDriverWait w = new WebDriverWait(driver,30);
	    WebElement el =w.until(ExpectedConditions.elementToBeClickable(ele));
	
	}
	

	
	

}
