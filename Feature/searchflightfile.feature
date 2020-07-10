Feature: 

Scenario Outline: Select the flight at chepest and fastest route
Given user navigates to the website "<url>"
Then cleartrip homepage should display
Then enter source as "<FromLocation>" and destination as "<ToLocation>"
And enter travel date
When click on search button
Then all available flight details should dispaly
Then sort out the details with fare And duration
Then select the cheapest and fastest flight

Examples: 
     |url|FromLocation|ToLocation|
     |https://www.cleartrip.com/do/search/flights|Hyderabad|Bangalore|

