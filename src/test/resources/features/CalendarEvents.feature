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
@TC2
Scenario: TC2 title column verification
 When user click on "Grid Settings" button
 And user selects next options below
        |Calendar         |
        |Start            |
        |End              |
        |Recurrent        |
        |Recurrence       |
        |Invitation status|
 Then Title column still displayed

 @TC3
 Scenario: TC3 Expanding Save and Close menu
   When user clicks on "Create Calendar Event" button
   Then expand "Save and Close" menu
   And verify that "Save and Close" , "Save and New" , and "Save" options are available

@TC4
Scenario: All Calender Event displays when cancel create calender event
  When user clicks on Create Calendar Event button
  And user clicks on Cancel button
  Then "All Calendar Events" subtitle is displayed


@TC8
Scenario:Verify "Repeat"checkbox is selected after clicking and "Daily" is selected by default under "Repeat" dropdown
  When user clicks on "Create Calendar Event" button
  And user check "Repeat"checkbox
  Then "Repeat" checkbox is selected
  And "Daily" is selected by default
  And other following options are also available in "Repeats" drop-down



@TC9



  @TC10
  Scenario: TC10 Verifying the message displayed after choosing number of occurrences as an Ends option
    When user clicks on "Create Calendar Event" button
    Then user selects "Repeat" checkbox
    When user select "After 10 occurrences" as an "Ends" option
    Then user verify the following message as a summary is displayed: "Summary: Daily every 1 day, end after 10 occurrences"


    @TC11
    Scenario: TC11 Verifying the message is displayed after choosing date as End option
      When user clicks on "Create Calendar Event" button
      Then user selects "Repeat" checkbox
      And user selects "Nov 18, 2021" as an "Ends" option
      Then user sees the following message as a summary is displayed: "Summary: Daily every 1 day, end by Nov 18, 2021"



  @TC12
  Scenario: TC12 Verifying "Repeat" checkbox message is displayed after selecting options
    When user clicks on "Create Calendar Event" button
    Then user selects "Repeat" checkbox
    And user selects "Weekly" options as a "Repeat" option
    And user select "Monday and Friday" options as a "Repeat On" options
    Then user verifies that "Monday and Friday" options are selected
    Then user verifies the following message as a summary is displayed: "Summary: Weekly every one week on Monday, Friday"