package library;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait_for_pageload {
	public WebDriver driver;
	public Long loadtime;
	public StopWatch pageLoad;

	public Wait_for_pageload(WebDriver dr) {

		this.driver = dr;
	}
	/*
	 * public void wait_till_pageload() { loadtime = (Long)
	 * ((JavascriptExecutor) driver)
	 * .executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;"
	 * );
	 * 
	 * System.err.println("Load time is " + loadtime);
	 * 
	 * }
	 */

	public double scorepageLoadtime(String text) {
		pageLoad = new StopWatch();
		pageLoad.start();

		String path = "//*[contains(text()," + "'" + text + "'" + ")]";

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));

		pageLoad.stop();
		double pageLoadTime_ms = pageLoad.getTime();

		double pageLoadTime_Seconds = pageLoadTime_ms / 1000;

		return pageLoadTime_Seconds;

	}

	public double startpageLoadtime() {
		pageLoad = new StopWatch();
		pageLoad.start();

		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//*[@id='divTextBx']/img")));

		pageLoad.stop();
		double pageLoadTime_ms = pageLoad.getTime();

		double pageLoadTime_Seconds = pageLoadTime_ms / 1000;

		return pageLoadTime_Seconds;

	}

}
