@login
  Feature: User should be able to login under store manager account

    Scenario: As a user, I should able to login
      Given user on the login page
      When user logs in as a "store manager"
      Then user should see Dashboard page
