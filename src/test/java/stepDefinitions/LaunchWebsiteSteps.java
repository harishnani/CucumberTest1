package stepDefinitions;

import com.aventstack.extentreports.model.Log;

import cucumber.api.java.en.Given;
import pageObjects.LaunchWebsite;

public class LaunchWebsiteSteps {
	
	@Given("^user navigates to the website \"([^\"]*)\"$")
	public void user_navigates_to_the_website_something(String strArg1) throws Throwable {
		LaunchWebsite.launchbrowser();
		LaunchWebsite.launchUrl(strArg1);
	}

}
