package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://gorest.co.in/public/v2";
        response = given()
                .when()
                .queryParam("page", "1")
                .queryParam("per_page", "20")
                .get("/users?page=1&per_page=20")
                .then().statusCode(200);
    }

    // 1. Verify the if the total record is 20
    @Test
    public void test01() {

        response.body("total", equalTo(20));
    }

    // 2. Verify the if the name of id = 5487 is equal to ”Hamsini Trivedi”/
    @Test
    public void test02() {
        response.body("[1].name", equalTo("Mohinder Shukla"));
    }

    //3. Check the single ‘Name’ in the Array list (Subhashini Talwar)
    @Test
    public void test03() {
        response.body("[2].name", equalTo("Mr. Mangala Chaturvedi"));
    }

    //4. Check the multiple ‘Names’ in the ArrayList (Mrs. Menaka Bharadwaj, Msgr. Bodhan Guha, Karthik Dubashi IV)
    @Test
    public void test04() {
        response.body("[1].name", hasItems("Mohinder Shukla", "Mr. Mangala Chaturvedi", "Bankim Saini Jr"));
    }

    // 5. Verify the email of userid = 5471 is equal “adiga_aanjaneya_rep@jast.org”
    @Test
    public void test05() {
        response.body("x[4].email", equalTo("jr_saini_bankim@tremblay-graham.info"));
    }

    //      6. Verify the status is “Active” of user name is “Shanti Bhat V”
    @Test
    public void test06() {
        response.body("x[7].status", equalTo("active"));
    }

    //    7. Verify the Gender = male of user name is “Niro Prajapat”
    @Test
    public void test07() {
        response.body("x[11].gender", equalTo("female"));
    }

}


