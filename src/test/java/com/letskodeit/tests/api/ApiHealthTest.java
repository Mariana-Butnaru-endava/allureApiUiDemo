package com.letskodeit.tests.api;

import com.letskodeit.config.ConfigReader;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

@Epic("API Tests")
@Feature("Website Health")
public class ApiHealthTest {

    @Test(description = "Verify base URL responds successfully")
    @Severity(SeverityLevel.NORMAL)
    public void shouldReturnSuccessfulStatusForBaseUrl() {
        RestAssured.baseURI = ConfigReader.get("apiBaseUrl");

        given()
            .relaxedHTTPSValidation()
        .when()
            .get("/")
        .then()
            .statusCode(lessThan(500))
            .time(lessThan(10000L));
    }
}
