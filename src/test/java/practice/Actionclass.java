package practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import library.Browser_factory;

public class Actionclass {
	public WebDriver driver;
	public Browser_factory b;
	private String baseurl = "https://uatmath2shine.azurewebsites.net/WorksheetBundling/";
	public Actions builder;

	@Test
	public Actionclass() {

		b = new Browser_factory();
		driver = b.initiate_browser("chrome");
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	@Test
	public void login() throws InterruptedException {

		driver.get(baseurl);

		WebElement s = driver.findElement(By.name("UserName"));
		s.sendKeys("performance.test");

		// builder.contextClick(s).build().perform(); -- context click

		driver.findElement(By.name("Password")).sendKeys("1234567");

		driver.findElement(By.cssSelector(".btn.btn-primary")).click();

		Thread.sleep(2000);
	}

	@Test(enabled = false)
	public void search() throws InterruptedException {

		WebElement searchicon = driver.findElement(By.cssSelector("#imgSearchIcon"));
		searchicon.click();

		Thread.sleep(2000);
		// builder.doubleClick(searchicon); double click

		// driver.close();
	}

	@Test
	public void navigate_to_startpage() throws InterruptedException {

		driver.findElement(By.xpath(".//*[@id='LeftChapter']/ul/li[1]/a/div")).click();

		Thread.sleep(2000);

		driver.findElement(By.cssSelector(".worksheetheading>a>h1")).click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector(".btn.btn-math2shine.start-button")).click();
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,600)", "");

	}
	@Test
	public void draganddrop() {

		//WebElement sciblingpad = driver.findElement(By.xpath(".//*[@id='tblScribling']/div[2]/canvas[2]"));

		//builder.dragAndDropBy(sciblingpad,100,100);
		builder.moveByOffset(100,100);
		
		
		

		int xpos = driver.manage().window().getPosition().getX();
		int ypoas = driver.manage().window().getPosition().getY();
		System.out.println(xpos);
		System.out.println(ypoas);

	}

}
