Feature: Search Flights

Scenario Outline: Select the flight at chepest and fastest route
Given user navigates to the website "<url>"
When enter source as "<FromLocation>" and destination as "<ToLocation>"
And enter travel date
Then click on search button
Then all available flight details should dispaly
Then sort out the details with fare and duration
Then select the cheapest and fastest flight

Examples: 
    |url|FromLocation|ToLocation|
    |https://www.cleartrip.com/do/search/flights|Hyderabad|Bangalore|
    |https://www.cleartrip.com/do/search/flights|Hyderabad|Chennai|
     
