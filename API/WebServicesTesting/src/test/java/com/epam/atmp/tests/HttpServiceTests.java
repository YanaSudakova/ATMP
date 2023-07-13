package com.epam.atmp.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;

public class HttpServiceTests {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void testStatusCode() {
        given()
                .when()
                .get("users")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testResponseHeader(){
        given()
                .when()
                .get("users")
                .then()
                .assertThat()
                .header("content-type", equalTo("application/json; charset=utf-8"));
    }

    @Test
    public void testResponseBody(){
        given()
                .when()
                .get("users")
                .then()
                .assertThat()
                .body(".", hasSize(10));
    }
}
