package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import utility.LogFile;

public class HomePage extends LaunchWebsite{
	
	public static void enterSource(String place) throws InterruptedException {
		enterLocations("from", place);
		LogFile.info(place + " entered as Source Location");
	}

	public static void enterDestination(String place) throws InterruptedException {
		enterLocations("to", place);
		LogFile.info(place + " entered as Destination Location");
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
		LogFile.info("Entered the date successfully!");
	}

	public static void clickSearch() {
		driver.findElement(By.id("submit_search_form")).click();
		LogFile.info("Search Flight Submit Button Successfully Clicked.");
	}

}
