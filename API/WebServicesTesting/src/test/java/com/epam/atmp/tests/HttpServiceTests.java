package com.epam.atmp.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;

public class HttpServiceTests {

    private static final String ENDPOINT = "https://jsonplaceholder.typicode.com/users";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = ENDPOINT;
    }

    @Test
    public void testStatusCode() {
        given()
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testResponseHeader(){
        given()
                .when()
                .get()
                .then()
                .assertThat()
                .header("content-type", equalTo("application/json; charset=utf-8"));
    }

    @Test
    public void testResponseBody(){
        given()
                .when()
                .get()
                .then()
                .assertThat()
                .body(".", hasSize(10));
    }
}
