package com.vytrack.stepDefinitions;

import com.vytrack.pages.CalendarEvents;
import com.vytrack.utilities.BrowserUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class CalendarEventStepDefinition {

    CalendarEvents calendarEvents = new CalendarEvents();

    //TC1
    @Given("user navigates to {string} and {string}")
    public void user_navigates_to_and(String string1, String string2) {
        calendarEvents.navigateTo(string1, string2);
    }

    @When("user hovers on three dots for {string}")
    public void userHoversOnThreeDotsFor(String title) {
        calendarEvents.testersMeetingCalendarEvent(title);
        calendarEvents.hoverThreeDot();
    }

    @Then("{string}, {string} and {string} options are available")
    public void andOptionsAreAvailable(String view, String edit, String delete) {
        Assert.assertTrue(calendarEvents.threeDotOptionVerification(view, edit, delete));
    }


    //TC2
    @When("user click on {string} button")
    public void userClicksOnGridSettingsButton(String option) {
        calendarEvents.clickOnGridOptionsButton(option);
    }

    @And("user selects next options below")
    public void userSelectsNextOptionsBelow(List<String> checkboxes) {
        for (String each : checkboxes) {
            calendarEvents.GridSettingFilterCheckbox(each);
        }
    }

    @Then("Title column still displayed")
    public void titleColumnStillDisplayed() {

        Assert.assertTrue(calendarEvents.titleFilterVerification());
    }




    //TC3
    @When("user clicks on {string} button")
    public void userClicksOnButton(String createCalendarEvent) {
        calendarEvents.clickCreateCalendarEventButton();
    }

    @Then("expand {string} menu")
    public void expandMenu(String SaveAndClose) {
        calendarEvents.clickExpandSaveAndCloseButton();
    }

    @And("verify that {string} , {string} , and {string} options are available")
    public void verifyThatAndOptionsAreAvailable(String SaveAndClose, String SaveAndNew, String Save) {
        Assert.assertTrue(calendarEvents.optionsVerification(SaveAndClose, SaveAndNew, Save));
    }


    //TC4
    @When("user clicks on Create Calendar Event button")
    public void userClicksOnCreateCalendarEventButton() {
       calendarEvents.clickCreateCalendarEventBtn();
    }
    @And("user clicks on Cancel button")
    public void userClicksOnCancelButton() {
     calendarEvents.clickCancelBtn();
    }

    @Then("{string} subtitle is displayed")
    public void subtitleIsDisplayed(String expectedTitle) {
        BrowserUtils.wait(5);
        String actualTitle = calendarEvents.getAllCalendarEventTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }


    //TC8

    @And("user check {string}checkbox")
    public void userCheckCheckbox(String string) {
        BrowserUtils.wait(2);
        calendarEvents.clickRepeatCheckBox();
    }

    @Then("{string} checkbox is selected")
    public void checkboxIsSelected(String repeat) {
BrowserUtils.wait(3);
        Assert.assertTrue(calendarEvents.RepeatBoxIsSelectedVerification());
    }

    @And("{string} is selected by default")
    public void isSelectedByDefault(String daily) {
        BrowserUtils.wait(3);
        Assert.assertTrue(calendarEvents.RepeatDropDownVerification());
    }

    @And("other following options are also available in {string} drop-down")
    public void otherFollowingOptionsAreAlsoAvailableInDropDown(String string) {
BrowserUtils.wait(2);
 calendarEvents.clickRepeatDropdown();
 BrowserUtils.wait(1);
Assert.assertTrue(calendarEvents.RepeatsWeeklyOptionsVerification());
        BrowserUtils.wait(2);
Assert.assertTrue(calendarEvents.RepeatsMonthlyOptionsVerification());
        BrowserUtils.wait(2);
Assert.assertTrue(calendarEvents.RepeatsYearlyOptionsVerification());
    }









 //TC12
    @Then("user selects {string} checkbox")
    public void userSelectsCheckbox(String Repeat) {
        BrowserUtils.wait(3);
        calendarEvents.clickRepeatCheckbox();
    }

    @And("user selects {string} options as a {string} option")
    public void userSelectsOptionsAsAOption(String Weekly, String Repeat) {
        BrowserUtils.wait(3);
        calendarEvents.selectFromRepeatsDropdown();
    }

    @And("user select {string} options as a {string} options")
    public void userSelectOptionsAsAOptions(String MondayAndFriday, String RepeatOn) {
        BrowserUtils.wait(1);
        calendarEvents.clickOnMondayCheckbox();
        BrowserUtils.wait(1);
        calendarEvents.clickOnFridayCheckbox();
    }

    @Then("user verifies that {string} options are selected")
    public void userVerifiesThatOptionsAreSelected(String MondayAndFriday) {
        BrowserUtils.wait(2);
       calendarEvents.verifyMondayAndFridayDisplayed();
    }


    @Then("user verifies the following message as a summary is displayed: {string}")
    public void userVerifiesTheFollowingMessageAsASummaryIsDisplayed(String displayedMessage) {
        BrowserUtils.wait(2);
        Assert.assertTrue(calendarEvents.displayedMessageVerification(displayedMessage));
    }


    @And("user selects {string} as an {string} option")
    public void userSelectsAsAnOption(String Nov18_2021, String EndsOption) {
        calendarEvents.clickOnRadioButton();
        BrowserUtils.wait(1);
        calendarEvents.clickOnChooseADateInputBox();
        BrowserUtils.wait(2);
        calendarEvents.selectEndsDate();

    }

    @Then("user sees the following message as a summary is displayed: {string}")
    public void userSeesTheFollowingMessageAsASummaryIsDisplayed(String message) {
        BrowserUtils.wait(2);
        Assert.assertTrue(calendarEvents.MessageVerification());
    }

    @When("user select {string} as an {string} option")
    public void userSelectAsAnOption(String occurrences, String Ends) {
        BrowserUtils.wait(2);
        calendarEvents.clickAfterRadioBtn();
        BrowserUtils.wait(2);
        calendarEvents.sendKeysOccurrencesInputBox();
    }

    @Then("user verify the following message as a summary is displayed: {string}")
    public void userVerifyTheFollowingMessageAsASummaryIsDisplayed(String arg0) {
        BrowserUtils.wait(2);
        Assert.assertTrue(calendarEvents.verifyMessage());
    }



//    @Then("user verifies the following message as a summary is displayed:{string}")
//    public void userVerifiesTheFollowingMessageAsASummaryIsDisplayed(String arg0) {
//    }


}

