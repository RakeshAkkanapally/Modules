package com.M63;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.M63.selenium.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features="src/test/resources",
        glue={"com.M63.steps"},
        plugin = {
                "com.github.kirlionik.cucumberallure.AllureReporter",
                "pretty", "json:target/Cucumber.json",
                "html:target/cucumber-html-report"
        },tags = {"@ebay","@Smoke"}

)
public class RunAcceptanceTest {
    @BeforeClass
    public static void initSelenium(){BaseSelenium.init();}

    @AfterClass
    public static void closeSelenium(){BaseSelenium.close();}

}
