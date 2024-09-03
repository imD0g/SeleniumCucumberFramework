package org.com.api.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.com.api.BaseApiTest;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ApiSteps extends BaseApiTest {
    private Response response;
    private String authToken;

    @Given("I am authenticated as an (admin user|content creator|content editor|regular user)")
    public void i_am_authenticated_as_a(String userType) {
        String username, password;
        switch (userType) {
            case "admin user":
                username = "admin";
                password = "adminpass";
                break;
            case "content creator":
                username = "creator";
                password = "creatorpass";
                break;
            case "content editor":
                username = "editor";
                password = "editorpass";
                break;
            case "regular user":
            default:
                username = "user";
                password = "userpass";
                break;
        }
        authToken = getAuthToken(username, password);
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        response = given()
                .header("Authorization", "Bearer " + authToken)
                .when()
                .get(endpoint);
    }

    @When("I send a POST request to {string} with the following data:")
    public void i_send_a_post_request_to_with_the_following_data(String endpoint, io.cucumber.datatable.DataTable dataTable) throws JSONException {
        JSONObject requestParams = new JSONObject();
        for (Map.Entry<String, String> entry : dataTable.asMap()
                                                        .entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            requestParams.put(key, value);
        }

        response = given()
                .header("Authorization", "Bearer " + authToken)
                .body(requestParams.toString())
                .when()
                .post(endpoint);
    }

    @When("I send a PUT request to {string} with the following data:")
    public void i_send_a_put_request_to_with_the_following_data(String endpoint, io.cucumber.datatable.DataTable dataTable) throws JSONException {
        JSONObject requestParams = new JSONObject();
        for (Map.Entry<String, String> entry : dataTable.asMap()
                                                        .entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            requestParams.put(key, value);
        }

        response = given()
                .header("Authorization", "Bearer " + authToken)
                .body(requestParams.toString())
                .when()
                .put(endpoint);
    }

    @When("I send a DELETE request to {string}")
    public void i_send_a_delete_request_to(String endpoint) {
        response = given()
                .header("Authorization", "Bearer " + authToken)
                .when()
                .delete(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        response.then()
                .statusCode(statusCode);
    }

    @Then("the response should contain the user's information")
    public void the_response_should_contain_the_user_s_information() {
        response.then()
                .body("id", notNullValue())
                .body("username", notNullValue())
                .body("email", notNullValue());
    }

    @Then("the response should contain the created content item's ID")
    public void the_response_should_contain_the_created_content_item_s_id() {
        response.then()
                .body("id", notNullValue());
    }

    @Then("the response should contain the updated content information")
    public void the_response_should_contain_the_updated_content_information() {
        response.then()
                .body("title", equalTo("Updated Content API Test"))
                .body("description", equalTo("This content item was updated"))
                .body("status", equalTo("published"));
    }

    @Given("there is an existing content item with ID {string}")
    public void there_is_an_existing_content_item_with_id(String contentId) {
        // This step might involve creating a content item if it doesn't exist
        // For this example, we'll assume the content item exists
    }
}