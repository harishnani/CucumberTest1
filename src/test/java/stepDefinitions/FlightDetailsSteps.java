package stepDefinitions;

import cucumber.api.java.en.Then;
import pageObjects.FlightDetailsPage;

public class FlightDetailsSteps {
	
	@Then("^all available flight details should dispaly$")
	public void all_available_flight_details_should_dispaly() throws Throwable {
		FlightDetailsPage.displayFlights();
	}

	@Then("^sort out the details with fare and duration$")
	public void sort_out_the_details_with_fare_and_duration() throws Throwable {
		//SearchFlights.sortWithFare();
		//SearchFlights.sortWithDuration();
		FlightDetailsPage.selectFlight();

	}

	@Then("^select the cheapest and fastest flight$")
	public void select_the_cheapest_and_fastest_flight() throws Throwable {
		FlightDetailsPage.bookTheTicket();
	}


}
