package lib_methods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Scroll {
	public WebDriver driver;

	public Scroll(WebDriver drv) {
		this.driver = drv;

	}

	public void scroll_down(int pageheight) {

		try {
			String sc1 = "window.scrollBy(0," + pageheight + "),"+"\"\"" ;
			JavascriptExecutor js = (JavascriptExecutor) driver;
		

		js.executeScript(sc1);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void scroll_up(int pageheight) {
		try {
			String sc1 = "window.scrollBy(0," + pageheight + "),"+"\"\"" ;
			JavascriptExecutor js = (JavascriptExecutor) driver;
		

		js.executeScript(sc1);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}


}
