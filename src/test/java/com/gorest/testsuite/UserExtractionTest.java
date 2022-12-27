package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="https://gorest.co.in/public/v2";

        response =given()
                .when()
                .queryParam("page","1")
                .queryParam("per_page","20")
                .get("/users?page=1&per_page=20")
                .then().statusCode(200);
    }

    // 1. Extract the All Ids
    @Test
    public void test01() {
        List<Object> totalId = response.extract().path("id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total records are : " + totalId.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //2. Extract the all Names
    @Test
    public void test02() {
        List<String> allname = response.extract().path("name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Categories list are : " + allname);
        System.out.println("------------------End of Test---------------------------");
    }

    //3. Extract the name of 5 th object
    @Test
    public void test03() {
        String objectName = response.extract().path("[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of 5th store : " + objectName);
        System.out.println("------------------End of Test---------------------------");
    }

    //4. Extract the names of all object whose status = inactive
    @Test
    public void test04() {
        List<Integer> allInactiveStatus = response.extract().path("findAll{it.status=='inactive'}.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Status of Inactive: " + allInactiveStatus);
        System.out.println("------------------End of Test---------------------------");
    }
    //5. Extract the gender of all the object whose status = active
    @Test
    public void test05(){
        List<String> allactiveStatusGender = response.extract().path("findAll{it.status=='inactive'}.gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Status of Inactive: " + allactiveStatusGender);
        System.out.println("------------------End of Test---------------------------");
    }
    //6. Print the names of the object whose gender = female
    @Test
    public void test06(){
     List<String> allactiveStatusGenderfemale = response.extract().path("findAll{it.gender=='female'}.gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Status of Inactive: " + allactiveStatusGenderfemale);
        System.out.println("------------------End of Test---------------------------");
}
    //7. Get all the emails of the object where status = inactive
    @Test
    public void test07(){
        List<String> allEmailsofStatusGenderfemale = response.extract().path("findAll{it.status=='inactive'}.email");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Status of Inactive: " + allEmailsofStatusGenderfemale);
        System.out.println("------------------End of Test---------------------------");
    }
    //8. Get the ids of the object where gender = male
    @Test
    public void test08(){
        List<String> allactiveStatusGendermale = response.extract().path("findAll{it.gender=='male'}.gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Status of Inactive: " + allactiveStatusGendermale);
        System.out.println("------------------End of Test---------------------------");
    }
    //9. Get all the status
    @Test
    public void test9() {
        List<Integer> statusList = response.extract().path("status");
        statusList.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All Status list : " + statusList.size());
        System.out.println("------------------End of Test---------------------------");
    }
    //10. Get email of the object where name = Bankim Saini Jr
    public void test10() {
        List<?> emailsOfBankimSainiJr = response.extract().path("findAll{it.name=='Bankim Saini Jr'}.email");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Email Of Chandrakin Johar : " + emailsOfBankimSainiJr);
        System.out.println("------------------End of Test---------------------------");
    }
    //11. Get gender of id = 5345
    @Test
    public void test11() {
        List<?> getGenderOfId5345= response.extract().path("findAll{it.id== 5345}.gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Gender Of Id 5393 : " + getGenderOfId5345);
        System.out.println("------------------End of Test---------------------------");

    }


}
