package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.LogFile;


public class LaunchWebsite {
	static WebDriver driver;
	static WebDriverWait wait;
	static int j =1;
	public static void launchbrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		LogFile.info("Successfully launched the browser!");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public static void launchUrl(String url) {
		driver.get(url);
		LogFile.info("Successfully launched the url : " + url);
	}

}
