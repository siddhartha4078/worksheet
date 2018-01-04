package practice;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class Minimize {
	public WebDriver driver;

	public void m1() {

		Dimension d = new Dimension(200, 400);
		driver.manage().window().setSize(d);

	}

	public void m2() {

		driver.manage().window().setPosition(new Point(-200, 0));
	}
}
