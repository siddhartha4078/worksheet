package lib_methods;

import org.openqa.selenium.WebDriver;

public class Navigate {

	public WebDriver driver;

	public Navigate(WebDriver drv) {

		this.driver = drv;

	}

	public void navigate_to(String url) {

		driver.navigate().to(url);
	}

	public void navigate_back() {

		driver.navigate().back();
	}

	public void navigate_forward() {

		driver.navigate().forward();
	}

	public void Refresh() {

		driver.navigate().refresh();
	}

}
