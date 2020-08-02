package Runer;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class API {
  @Test
  public void f() {
	 /*Response it= given().log().all().get("https://reqres.in/api/users?page=2");
	 it.prettyPrint();
	 System.out.println(it.statusCode());*/
	  RestAssured.baseURI="https://reqres.in/";
	  given().log().all().queryParam("page", "2").get("api/users").then().log().all().assertThat().statusCode(200);
	  
  }
  @Test
  public void Methods() {
	  String bodisd="{\"email\": \"eve.holt@reqres.in\",\"password\": \"pistol\"}";
	 Response dt =given().log().all().contentType(ContentType.JSON)
			 .body(bodisd).post("https://reqres.in/api/register");
	  dt.prettyPrint();
	  System.out.println("This is status code ="+dt.statusCode());
	  System.out.println("Method ends here");
	  System.out.println("Going to start new");
  }
}
