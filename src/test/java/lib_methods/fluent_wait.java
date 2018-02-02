package lib_methods;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class fluent_wait {

	public WebDriver driver;

	public void fluentwait() {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

	}
}

/*
 * WebElement foo = wait.until(new Function<WebDriver, WebElement>() { public
 * WebElement apply(WebDriver driver) { return driver.findElement(By.id("foo"));
 * }
 * 
 * };
 */
