package lib_methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Select_dropdown {
	
	public WebDriver driver;
	public 	Select s;
	
	
	public  Select_dropdown(WebDriver drv){
	this.driver=drv;

	}
	
	public void select_by_index(int index,WebElement ele){
		s = new Select (ele);
		s.selectByIndex(index);

	}
	
	public void select_by_text(String text,WebElement ele){
		s = new Select (ele);
		s.selectByVisibleText(text);

	}

}
