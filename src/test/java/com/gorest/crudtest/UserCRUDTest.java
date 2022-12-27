package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {

    @Test
    public void verifyUserCreatedSuccessfully(){
        UserPojo userPojo = new UserPojo();
        userPojo.setId(5318);
        userPojo.setName("Rameshwar Varman");
        userPojo.setEmail("varman_rameshwar@johnston.info");
        userPojo.setGender("female");
        userPojo.setStatus("active");


        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization","4b23cf2956abd9c30acd1ed39e644dd4716c8a85c1a6acde3b4f5070bd79f4b3")
                .when()
                .body(userPojo)
                .post();
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void getAllCustomersInfo() {
        Response response = given()
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void UpdateCustomersInfo() {
        Response response = given()
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void deleteUser() {
        Response response = given()

                .header("Content-Type","application/json")
                .header("Authorization", "4b23cf2956abd9c30acd1ed39e644dd4716c8a85c1a6acde3b4f5070bd79f4b3")

                .when()
                .delete("/users/3828");
        response.then().statusCode(204);
        response.prettyPrint();
    }



}
