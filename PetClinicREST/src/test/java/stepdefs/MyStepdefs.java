package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class MyStepdefs {

    private RequestSpecification request;
    private Response response;

    @Given("^I have acces to perform GET request$")
    public void iHaveAccesToPerformGETRequest() throws Throwable {
        request = given().
                baseUri("http://bhdtest.endava.com:8080/petclinic/api").
                        contentType(ContentType.JSON);
    }

    @When("^I perform a GET request to \"([^\"]*)\"$")
    public void iPerformAGETRequestTo(String path) throws Throwable {
        response =request.when().get(path);
    }

    @Then("^I will have status code \"([^\"]*)\"$")
    public void iWillHaveStatusCode(int statusCode) throws Throwable {
        response.then().statusCode(statusCode);
        System.out.println(response.asString());

    }

    @Given("^I have access to perform POST request$")
    public void iHaveAccessToPerformPOSTRequest() throws Throwable {
        request=given().baseUri("http://bhdtest.endava.com:8080/petclinic/api").
               body("{\"name\": \"zebra\"}").contentType(ContentType.JSON);
}

    @When("^I perform a POST request to \"([^\"]*)\"$")
    public void iPerformAPOSTRequestTo(String path) throws Throwable {
        response=request.when().post(path);

    }

    @Given("^I have access to perform PUT request$")
    public void iHaveAccessToPerformPUTRequest() throws Throwable {
        request=given().baseUri("http://bhdtest.endava.com:8080/petclinic/api").
                pathParam("petTypeID", 132).
                body("{\"name\": \"zebraupdated\"}").contentType(ContentType.JSON);
    }

    @When("^I perform a PUT request to \"([^\"]*)\"$")
    public void iPerformAPUTRequestTo(String path) throws Throwable {
        response=request.when().put(path);
    }

    @Then("^I will have the status code \"([^\"]*)\"$")
    public void iWillHaveTheStatusCode(int statusCode) throws Throwable {
        response.then().statusCode(statusCode);
        System.out.println(response.asString());
    }

    @Given("^I have access to perform DELETE request$")
    public void iHaveAccessToPerformDELETERequest() throws Throwable {
        request=given().baseUri("http://bhdtest.endava.com:8080/petclinic/api").
                pathParam("petTypeID", 132).
                body("{\"name\": \"zebraupdated\"}").contentType(ContentType.JSON);
    }

    @When("^I perform a DELETE request to \"([^\"]*)\"$")
    public void iPerformADELETERequestTo(String path) throws Throwable {
        response=request.when().delete(path);
    }
}
