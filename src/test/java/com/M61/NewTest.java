package com.M61;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.junit.Assert;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void TestUsers() {
	  RestAssured.baseURI="https://jsonplaceholder.typicode.com";
	  RestAssured.when().get("/users/").then().statusCode(200);
  }
  
  @Test
  public void TestResponseHeader(){
	  RestAssured.baseURI="https://jsonplaceholder.typicode.com";
	  RestAssured.when().get("/users").then().contentType("application/json; charset=utf-8");
  }
  
  @Test
  public void TestResponseContent(){
	  RestAssured.baseURI="https://jsonplaceholder.typicode.com";
	  RequestSpecification request = RestAssured.given();
	  Response response = request.get("/users");

	  JsonPath jsonPathEvaluator=response.jsonPath();
	  List<String> list = jsonPathEvaluator.getList("username");
	  Assert.assertTrue("Consists of array of 10 users", list.size()==10);
	  

  }
}
