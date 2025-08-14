package com.ecommerce.api.tests;

import com.ecommerce.api.models.LoginRequest;
import com.ecommerce.api.models.LoginResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginApiTest extends BaseTest {

    @DataProvider(name = "validCredentials")
    public Object[][] validCredentials() {
        return new Object[][]{
                {"hmsheethal123@gmail.com", "ZGVtbzEyMw=="} // Base64 password
        };
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][]{
                {"invaliduser@test.com", "ZGVtbzEyMw=="},
                {"hmsheethal123@gmail.com", "YmFkUGFzcw=="}
        };
    }

    @Test(dataProvider = "validCredentials")
    public void loginWithValidCredentials(String username, String passwordB64) {
        LoginRequest request = new LoginRequest(username, passwordB64);

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(request)
                .when()
                        .post("/login")
                .then()
                        .statusCode(200)
                        .extract().response();

        String contentType = response.getContentType();

        if (contentType != null && contentType.contains("application/json")) {
            String textResponse = response.asString();
            Assert.assertTrue(textResponse.toLowerCase().contains("token") || textResponse.toLowerCase().contains("auth"),
                    "Expected token or auth in text response: " + textResponse);

            // Optionally extract token from plain text
            if (textResponse.contains(":")) {
                String token = textResponse.split(":", 2)[1].trim();
                Assert.assertFalse(token.isEmpty(), "Token should not be empty");
                token = token.replaceAll("^\"|\"$", "");
                System.out.println("Extracted token: " + token);
            }
        }
    }

    @Test(dataProvider = "invalidCredentials")
    public void loginWithInvalidCredentials(String username, String passwordB64) {
        LoginRequest request = new LoginRequest(username, passwordB64);

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(request)
                .when()
                        .post("/login")
                .then()
                        .statusCode(200)
                        .extract().response();

        String textResponse = response.asString().toLowerCase();
        Assert.assertTrue(
                textResponse.contains("error")
                        || textResponse.contains("wrong")
                        || textResponse.contains("invalid")
                        || textResponse.contains("fail"),
                "Expected error message for invalid login but got: " + textResponse
        );
    }
}
