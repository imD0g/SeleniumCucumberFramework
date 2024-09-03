package org.com.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;


public class BaseApiTest {
    protected static RequestSpecification requestSpec;

    @BeforeAll
    public static void setup() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://your-cms-api-url.com")
                .setContentType("application/json")
                .build();

        RestAssured.requestSpecification = requestSpec;
    }

    protected String getAuthToken(String username, String password) {
        // Implement your authentication logic here
        // This is just a placeholder implementation
        return RestAssured.given()
                          .param("username", username)
                          .param("password", password)
                          .when()
                          .post("/auth/token")
                          .then()
                          .statusCode(200)
                          .extract()
                          .path("token");
    }
}