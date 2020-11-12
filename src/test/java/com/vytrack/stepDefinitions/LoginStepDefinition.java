package com.vytrack.stepDefinitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition {

    LoginPage loginPage =new LoginPage();

    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url") );
    }



    @When("user logs in as a {string}")
    public void user_logs_in_as_a(String string) {
       loginPage.login(string);
    }

    @Then("user should see {string} page")
    public void user_should_see_dashboard_page(String title) {
        Assert.assertTrue(loginPage.getTitle(title));
    }

}
