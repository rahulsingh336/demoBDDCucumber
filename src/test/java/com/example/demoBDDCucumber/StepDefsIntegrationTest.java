package com.example.demoBDDCucumber;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class StepDefsIntegrationTest extends SpringIntegrationTest {

    private final String SERVER_URL = "http://localhost";
    private final String VERSION_ENDPOINT = "/version";
    private final String BOOK_ENDPOINT = "/book/";

    @LocalServerPort
    private int port;

    private String versionEndpoint() {
        return SERVER_URL + ":" + port + VERSION_ENDPOINT;
    }

    private String bookEndpoint() {
        return SERVER_URL + ":" + port + BOOK_ENDPOINT;
    }

    @When("^the client calls /version$")
    public void the_client_issues_GET_version() throws Throwable {
        executeGet(versionEndpoint());
    }

    @When("^the client calls /book (-?\\d+)$")
    public void the_client_book_issues_GET_version(Integer id) throws Throwable {
        executeGet(bookEndpoint() + id);
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @And("^the client receives server version (.+)$")
    public void the_client_receives_server_version_body(String version) throws Throwable {
        assertThat(latestResponse.getBody(), is(version));
    }

    @Given("A book to get")
    public void aBookToGet() {
        System.out.println("Coming here in Given");
    }

    @And("^the client got response (.+)$")
    public void theClientGotResponseResp(String resp) {
        assertThat(latestResponse.getBody(), is(resp));
    }
}
