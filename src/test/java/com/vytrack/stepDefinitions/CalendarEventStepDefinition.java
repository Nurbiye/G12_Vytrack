package com.vytrack.stepDefinitions;

import com.vytrack.pages.CalendarEvents;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CalendarEventStepDefinition {

    CalendarEvents calendarEvents = new CalendarEvents();

    //TC1
    @Given("user navigates to {string} and {string}")
    public void user_navigates_to_and(String string1, String string2) {
        calendarEvents.navigateTo(string1,string2);
    }

    @When("user hovers on three dots for {string}")
    public void userHoversOnThreeDotsFor(String title) {
            calendarEvents.testersMeetingCalendarEvent(title);
            calendarEvents.hoverThreeDot();
    }

    @Then("{string}, {string} and {string} options are available")
    public void andOptionsAreAvailable(String view, String edit, String delete) {
        Assert.assertTrue(calendarEvents.threeDotOptionVerification(view,edit,delete));
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
        String actualTitle = calendarEvents.getAllCalendarEventTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

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
        Assert.assertTrue(calendarEvents.optionsVerification(SaveAndClose,SaveAndNew,Save));
    }
}

