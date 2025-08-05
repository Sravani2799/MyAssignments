Feature: Edit a account in Salesforce

#Background:
#Given Start the browser and enter the URL

@EditAccount
Scenario: Verify the phone number after editing
When Enter the username as 'vidyar@testleaf.com'
And Enter the password in as 'Sales@123'
And click on the login button
And click on the App launcher
And click on View All
And scroll to the Accounts and click it
And Search for the account name 'Sravani'
And Click on the dropdown of the first account
And Click on the edit
When select Technology Partner under Type
And select Healthcare under Industry
And Enter the Billing Address as 'VSKP,Allipuram'
And Enter the Shipping Address as 'VSKP,Allipuram-530004'
And Set the Customer Priority to Low
And Set SLA to Silver
And Set Active to No
And Entering a unique number in the Phone field
And Set Upsell Oportunity to No
And Click Save
Then Verify the Phone Number

