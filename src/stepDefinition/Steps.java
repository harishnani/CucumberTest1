package stepDefinition;		

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;		

public class Steps {	

	@Given("^user navigates to the website \"([^\"]*)\"$")
	public void user_navigates_to_the_website_something(String strArg1) throws Throwable {
		SearchFlights.launchbrowser();
		SearchFlights.launchUrl(strArg1);
	}

	@Then("^cleartrip homepage should display$")
	public void cleartrip_homepage_should_display() throws Throwable {
		
	}

	@Then("^enter source as \"([^\"]*)\" and destination as \"([^\"]*)\"$")
	public void enter_source_as_something_and_destination_as_something(String strArg1, String strArg2) throws Throwable {
		SearchFlights.enterSource(strArg1);
		SearchFlights.enterDestination(strArg2);
	}

	@And("^enter travel date$")
	public void enter_travel_date() throws Throwable {
		SearchFlights.enterTravelDate();
	}

	@When("^click on search button$")
	public void click_on_search_button() throws Throwable {
		SearchFlights.clickSearch();
	}

	@Then("^all available flight details should dispaly$")
	public void all_available_flight_details_should_dispaly() throws Throwable {
		SearchFlights.displayFlights();
	}

	@Then("^sort out the details with fare And duration$")
	public void sort_out_the_details_with_fare_and_duration() throws Throwable {
		//SearchFlights.sortWithFare();
		SearchFlights.sortWithDuration();

	}

	@Then("^select the cheapest and fastest flight$")
	public void select_the_cheapest_and_fastest_flight() throws Throwable {
		SearchFlights.bookTheTicket();
	}


}




