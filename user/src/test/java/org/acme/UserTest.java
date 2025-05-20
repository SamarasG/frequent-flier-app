package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


@Disabled
@QuarkusTest
class UserTest {

    @Test
    void testGetAllUsers() {
        given()
                .when().get("/users")
                .then()
                .statusCode(200);
    }
}