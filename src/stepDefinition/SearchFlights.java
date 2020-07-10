package stepDefinition;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchFlights {
	static WebDriver driver;
	static WebDriverWait wait;
	static int j =0;
	public static void launchbrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void enterSource(String place) throws InterruptedException {
		enterLocations("from", place);
	}

	public static void enterDestination(String place) throws InterruptedException {
		enterLocations("to", place);
	}

	public static void enterLocations(String xpath , String location) throws InterruptedException{
		WebElement loc = driver.findElement(By.name(xpath));
		loc.clear();
		loc.sendKeys(location);
		Thread.sleep(5000);
		loc.sendKeys(Keys.ARROW_DOWN);
		loc.sendKeys(Keys.ENTER);
	}

	public static void enterTravelDate() throws InterruptedException {
		WebElement traveldatefiled = driver.findElement(By.name("depart_date"));
		traveldatefiled.click();
		WebElement travelday = driver.findElement(By.xpath("//a[contains(@class,'ui-state-default ui-state-highlight')]//parent::td//following-sibling::td[1]/a"));
		travelday.click();
	}

	public static void clickSearch() {
		driver.findElement(By.id("submit_search_form")).click();
	}

	public static void displayFlights() {
		wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("sorterTpl"))));
		System.out.println("page is loaded and displaying all avalilable flights");
		//driver.switchTo().alert().accept();
	}

	public static void sortWithFare() throws InterruptedException {
		driver.findElement(By.xpath("(//a[@data-sort='price'])[1]")).click();;
		List<WebElement> avalibleFlights = driver.findElements(By.xpath("//li[contains(@class,'listItem')]"));
		Iterator<WebElement> itr = avalibleFlights.iterator();
		int fare = 0;
		for(int i=0;i<=avalibleFlights.size()-1;i++) {
			String text = avalibleFlights.get(i).getText();
			String[] text1 = text.split("\\R");
			text1[3]=text1[3].replace(",", "");
			String[] text2 = text1[3].split("\\.");
			fare = Integer.parseInt(text2[1]);
			if (fare > Integer.parseInt(text2[1]))
			fare = Integer.parseInt(text2[1]);
		}
		System.out.println(fare);
	}
		
		public static void sortWithDuration() throws InterruptedException, ParseException {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@data-sort='dur']")).click();
			List<WebElement> avalibleFlights = driver.findElements(By.xpath("//li[contains(@class,'listItem')]"));
			Iterator<WebElement> itr = avalibleFlights.iterator();
			String starttime = null;
			for(int i=0;i<=avalibleFlights.size()-1;i++) {
				String text = avalibleFlights.get(i).getText();
				String[] text1 = text.split("\\R");
				String[] text2 = text1[2].split(" ");
				SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
				if (dateFormat.parse(text2[0]).after(dateFormat.parse("15:00"))&&dateFormat.parse(text2[0]).before(dateFormat.parse("18:00"))) {
				starttime = text2[0];
				j = i+1;	
				}
			}
			System.out.println(starttime);
	}
	
		public static void bookTheTicket() {
		driver.findElement(By.xpath("(//li[contains(@class,'listItem')])["+j+"]/table/tbody/tr[2]/td[3]/button")).click();
		driver.close();
		}
}
