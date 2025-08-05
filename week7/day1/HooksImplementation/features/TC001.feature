Feature: Creating Account in LeafTaps Application

#Background: 
#Given start the browser and load URL

@CreateAccount
Scenario: Create account with All required inputs
And Click Accounts
And Click Create Account
And Enter Account Name as 'Sravani'
And Enter Phone Number as '879075'
And Click Submit at Create Account
Then Account Details page should be Loaded