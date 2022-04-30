package com.example.demoBDDCucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class StepdefsGoogle {

    private WebDriver driver;
    private WebElement elm;
    private String searchKeyWord;

    @When("^the client calls (.+)$")
    public void theClientCallsURLGiven(String url) {
        System.setProperty("webdriver.chrome.driver", "test/chrome/chromedriver.exe");
        //webdriver instance
        driver = new ChromeDriver();
        // implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //maximize the browser window
        driver.manage().window().maximize();
        //url launch
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Then("^the client types (.+)$")
    public void the_client_types_search_keyword(String username){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //element identify
        //elm = driver.findElement(By.tagName("input"));
        elm = driver.findElement(By.name("q"));
        //perform action - input text
        elm.sendKeys(username);
        // Explicit wait condition for search results
        WebDriverWait w = new WebDriverWait(driver, 5);
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
        elm.submit();
        this.searchKeyWord = username;
        //sleep();

    }


    @And("^the client validates output")
    public void the_client_validates_output() throws Throwable {
        //sleep();
        String s = elm.getAttribute("value");
        //validate result with Assertion
        Assert.assertEquals(s, searchKeyWord);
        //quit browser
        driver.quit();
    }


    private void sleep() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
