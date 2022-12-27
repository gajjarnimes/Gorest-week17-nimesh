package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PostsExtractionTest {
    static ValidatableResponse response;
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="https://gorest.co.in/public/v2";
        response =given()
                .when()
                .queryParam("page","1")
                .queryParam("per_page","20")
                .get("/posts?page=1&per_page=25")
                .then().statusCode(200);
    }
       //1. Extract the title
       @Test
       public void test001() {
           List<Object> title = response.extract().path("title");

           System.out.println("------------------StartingTest---------------------------");
           System.out.println("Title are : " + title);
           System.out.println("------------------End of Test---------------------------");
       }
      //2. Extract the total number of record
      @Test
      public void test002() {
          List<Object> totalRecord = response.extract().path("record");

          System.out.println("------------------StartingTest---------------------------");
          System.out.println("Title are : " + totalRecord);
          System.out.println("------------------End of Test---------------------------");
      }
      //3. Extract the body of 15 th record
      @Test
      public void test003() {
          String body = response.extract().path("[14].body");

          System.out.println("------------------StartingTest---------------------------");
          System.out.println("Body of 15th Record : " + body);
          System.out.println("------------------End of Test---------------------------");
      }
    //4. Extract the user_id of all the records
    @Test
    public void test004() {
        List<Integer> userId = response.extract().path("user_id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total records are : " + userId);
        System.out.println("------------------End of Test---------------------------");
    }
    //5. Extract the title of all the records
    @Test
    public void test05(){

            List<Integer> title= response.extract().path("title");
            System.out.println("------------------StartingTest---------------------------");
            System.out.println("Total records are : " + title);
            System.out.println("------------------End of Test---------------------------");

    }
    //6. Extract the title of all records whose user_id = 5456
    @Test
    public void test06() {

        List<Integer> titleofallrecords = response.extract().path("data.findAll{it.user_id=='5522'}.record");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total records are : " + titleofallrecords);
        System.out.println("------------------End of Test---------------------------");
    }

        // 7. Extract the body of all records whose id = 2671
        @Test
        public void test07() {

            List<Integer> bodyofallrecordswhoseid2670 = response.extract().path("d[9].body.findAll{it.id=='2670'}.body");
            System.out.println("------------------StartingTest---------------------------");
            System.out.println("Total records are : " + bodyofallrecordswhoseid2670);
            System.out.println("------------------End of Test---------------------------");
        }



        }

