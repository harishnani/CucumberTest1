package pageObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.LogFile;


public class FlightDetailsPage extends LaunchWebsite {

	static Logger log = Logger.getLogger("");
	public static void displayFlights() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[contains(text(),'Non-stop ')])[2]"))));
		LogFile.info("page is loaded and displaying all avalilable flights");
	}

	public static void sortWithFare() throws InterruptedException {
		driver.findElement(By.xpath("(//a[@data-sort='price'])[1]")).click();;
		List<WebElement> avalibleFlights = driver.findElements(By.xpath("//li[contains(@class,'listItem')]"));
		avalibleFlights.iterator();
		int fare = 0;
		for(int i=0;i<=avalibleFlights.size()-1;i++) {
			String text = avalibleFlights.get(i).getText();
			String[] text1 = text.split("\\R");
			text1[3]=text1[3].replace(",", "");
			String[] text2 = text1[3].split("\\.");
			fare = Integer.parseInt(text2[1]);
			if (fare > Integer.parseInt(text2[1])) {
			fare = Integer.parseInt(text2[1]);
			j=i+1;
			}
		}
		System.out.println(fare);
	}
		
		public static void sortWithDuration() throws InterruptedException, ParseException {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@data-sort='dur']")).click();
			List<WebElement> avalibleFlights = driver.findElements(By.xpath("//li[contains(@class,'listItem')]"));
			avalibleFlights.iterator();
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

		public static void selectFlight() throws InterruptedException {
			driver.findElement(By.xpath("(//a[contains(text(),'Non-stop ')])[2]")).click();
			Thread.sleep(2000);
			if (driver.findElements(By.xpath("//label[contains(text(),'Evening')]")).size()==1)
				driver.findElement(By.xpath("//label[contains(text(),'Evening')]")).click();
			else 
				driver.findElement(By.xpath("//label[contains(text(),'Night')]")).click();
			
		}
		
		public static void bookTheTicket() {
			driver.findElement(By.xpath("(//li[contains(@class,'listItem')])[1]/table/tbody/tr[2]/td[3]/button")).click();
			LogFile.info("Selected the best flight successfully");
			driver.close();
			}
}
