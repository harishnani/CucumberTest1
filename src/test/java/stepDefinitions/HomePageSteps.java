package stepDefinitions;		

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;
import pageObjects.FlightDetailsPage;
import pageObjects.HomePage;
import pageObjects.LaunchWebsite;

public class HomePageSteps {	

	@When("^enter source as \"([^\"]*)\" and destination as \"([^\"]*)\"$")
	public void enter_source_as_something_and_destination_as_something(String strArg1, String strArg2) throws Throwable {
		HomePage.enterSource(strArg1);
		HomePage.enterDestination(strArg2);
	}

	@And("^enter travel date$")
	public void enter_travel_date() throws Throwable {
		HomePage.enterTravelDate();
	}

	@Then("^click on search button$")
	public void click_on_search_button() throws Throwable {
		HomePage.clickSearch();
	}

}




