package com.vytrack.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features",
        glue="com/vytrack/stepDefinitions",
        tags="@TC1",

        dryRun = false


)

public class CucumberRunner {

}
