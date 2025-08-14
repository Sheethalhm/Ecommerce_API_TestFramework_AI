package com.ecommerce.api.tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://api.demoblaze.com";
    }
}
