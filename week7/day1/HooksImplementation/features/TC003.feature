Feature: Deleting Account in LeafTaps Application

#Background: 
#Given start the browser and load URL

@DeleteAccount
Scenario: Deleting account in leaftaps
And Click Accounts
And Click Find Account
And Click Find by Phone
And Enter Phone Number to search as '879075'
And Click on the first resulting account
And Click Deactivate Account
And Handle and Click OK in the Alert
Then Account Details page should be loaded
And Print and verify the Account status