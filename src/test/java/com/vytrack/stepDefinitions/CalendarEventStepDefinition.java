package com.vytrack.stepDefinitions;

import com.vytrack.pages.CalendarEvents;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CalendarEventStepDefinition {

    CalendarEvents calendarEvents = new CalendarEvents();


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
}
