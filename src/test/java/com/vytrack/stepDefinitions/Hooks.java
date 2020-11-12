package com.vytrack.stepDefinitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUP(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
        System.out.println("Starting automation");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @After
    public void tearDown(){
        System.out.println("End of automation");
        Driver.closeDriver();
    }




}
