package bdd.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class testFestiSteps {

    private static Response response;

    @LocalServerPort
    private int port;

    @Before // to use the same port as the application
    public void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Given("A user publishes a get request to testFesti")
    public void requestingtestFesti() {
        RequestSpecification request = RestAssured.given();

        /*
         JSONObject requestParams = new JSONObject();
         requestParams.put("name", name); // where name can be a parameter of the function
        */

        response = request
                //.header("Content-Type", "application/json")
                //.body(requestParams.toJSONString())
                .get("/testFesti");
    }

    @Then("API should reply findit")
    public void apiRepliesfindit() {
        assertThat(response.getStatusCode()).isEqualTo(200); // Ensure status code is OK
        assertThat(response.getBody().asString()).contains("<h1>Findit</h1>"); // Adjust this assertion according to your HTML content
    }
}