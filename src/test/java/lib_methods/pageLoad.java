package lib_methods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class pageLoad {

	public WebDriver driver;

	public pageLoad(WebDriver drv)

	{
		this.driver = drv;
	}

	public double response() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		double loadtime = (Long) ((JavascriptExecutor) driver)
				.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		return loadtime/1000;
	}
}
