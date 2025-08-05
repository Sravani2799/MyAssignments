Feature: Editing Account in LeafTaps Application

#Background: 
#Given start the browser and load URL

@EditAccount
Scenario: Editing account in leaftaps
And Click Accounts
And Click Find Account
And Click Find by Phone
And Enter Phone Number to search as '879075'
And Click on the first resulting account
And Click Edit
And Enter 'SraRam' in Local Name
And Click Save in Edit Account Page
Then Account Details page should be loaded 
And print and verify the Local Name
