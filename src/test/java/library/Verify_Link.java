package library;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Verify_Link {

	public WebDriver driver;
	public String url;

	public Verify_Link(WebDriver drv) {

		this.driver = drv;

	}

	public void verify(String url) throws IOException {

		List<WebElement> l = driver.findElements(By.tagName("a"));
		System.out.println("Number of links ----"+l.size());

		for (int i = 0; i < l.size(); i++) {
			WebElement ele = l.get(i);
			url = ele.getAttribute("href");

			try {
				URL u = new URL(url);

				HttpURLConnection httpconnections = (HttpURLConnection) u.openConnection();
				httpconnections.setConnectTimeout(3000);
				httpconnections.connect();

				if (httpconnections.getResponseCode() == 200) {
					System.out.println(url + "---------" + httpconnections.getResponseCode());
				}

				else if (httpconnections.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
					System.out.println(url + "---------" + httpconnections.getResponseCode());
				}

			} catch (Exception e) {

			}
		}
	}
}
