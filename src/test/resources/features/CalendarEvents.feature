@calendarEvents
  Feature: Calendar events test cases
    Background: Given user is on the Calendar Events page
      Given user on the login page
      And user logs in as a "store manager"
      And user navigates to "Activities" and "Calendar Events"

@TC1
Scenario: TC1 three dots case
  When user hovers on three dots for "Testers meeting"
  Then "View", "Edit" and "Delete" options are available


@TC4
Scenario: All Calender Event displays when cancel create calender event
  When user clicks on Create Calendar Event button
  And user clicks on Cancel button
  Then "All Calendar Events" subtitle is displayed