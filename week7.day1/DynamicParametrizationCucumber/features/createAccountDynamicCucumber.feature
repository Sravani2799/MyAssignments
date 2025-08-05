Feature: Creating Account in Salesforce

#Background: 
#Given Start the browser and enter the url

@CreateAccount
Scenario Outline: Creating Account for multiple/dynamic Data
When The username is 'vidyar@testleaf.com'
And The password is 'Sales@123'
And Click on the login button
And Click App Launcher
And Click View All
And Click Sales button
And Click Accounts Tab
And Click New Account
And Enter Account name as <accountName>
And Select Public under ownership dropdown
And Click on the Save button
Then Verify the Account created and window

Examples:
|accountName|
|Sravani|
|Ramana|
|Satish|