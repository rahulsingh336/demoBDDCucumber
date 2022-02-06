package com.example.demoBDDCucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", plugin = {"json:target/cucumber.json"},  glue = {"com.example.demoBDDCucumber"})
public class CucumberIntegrationTest extends SpringIntegrationTest {
}