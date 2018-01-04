package practice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import com.pageObject.Landing;
import com.pageObject.Login;

import library.Browser_factory;

public class popup_window {

	public Browser_factory b;
	public WebDriver driver;
	public Login l;
	public Landing lan;

	public popup_window() {

		b = new Browser_factory();
		driver = b.initiate_browser("Chrome");
		driver.get("http://uatmath2shine.azurewebsites.net/PreuatAdmin");
		driver.manage().window().maximize();
		l = PageFactory.initElements(driver, Login.class);
		lan = PageFactory.initElements(driver, Landing.class);
	}

	@Test
	public void navigate() throws FindFailed, InterruptedException {
		l.Enter_credentials("orgadmin", "1234567");

		driver.findElement(By.cssSelector(".btn.btn-default.button")).click();

		lan.Click_on_assignmenttype("Master Data");
		Thread.sleep(3000);

		driver.findElement(By.xpath("html/body/div[1]/nav/div/ul[1]/li[3]/ul/li[11]/a")).click();
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath("html/body")).sendKeys("text");
		Thread.sleep(3000);

		
		  String MainWindow=driver.getWindowHandle();
		  System.out.println("main window"+MainWindow);
		  
		driver.findElement(By.cssSelector(".k-tool-icon.k-icon.k-i-html")).click();
		
		
		Set<String>s =  driver.getWindowHandles();
		
		Iterator <String> i = s.iterator();
		
		while(i.hasNext()){
			
			String handle=i.next();
			System.out.println(handle);
			
			
		}
		
		
	}

}
