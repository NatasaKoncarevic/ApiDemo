package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import Pojo.AddPlace;
import Pojo.Location;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.EnumResources;
import resources.TestDataBuild;
import resources.Utils;


public class StepDefination extends Utils{
	
	RequestSpecification req2;
	ResponseSpecification res;
	Response response;
	TestDataBuild data= new TestDataBuild();
	static String place_id;
	
	
	@Given("Add Place Payload {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
	
	 
	 //res=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	 req2=given().log().all().spec(requestSpecification()).body(data.addPlacePayLoad(name,language,address));
	 
	}
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method){
		EnumResources resourceAPI=EnumResources.valueOf(resource);
		;
		System.out.println(resourceAPI.getResource());
	    // Write code here that turns the phrase above into concrete actions
		res=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		
		if(method.equals("POST")) 
			response=req2.when().post(resourceAPI.getResource());
			else if(method.equals("GET")) 
				response=req2.when().get(resourceAPI.getResource());
			
					 
			
		}
	
	@Then("the API call got succes with status code")
	public void the_api_call_got_succes_with_status_code() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expectedValue) {
	 
		Assert.assertEquals(getJsonPath(response,key), expectedValue);
	}



	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		place_id= getJsonPath(response,"place_id");
		 req2=given().log().all().spec(requestSpecification()).queryParam("place_id", place_id);
		 user_calls_with_http_request(resource, "GET");
		 String actualName= getJsonPath(response,"name");
		 Assert.assertEquals(actualName,expectedName);
	}
	
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		//NE TREBA NAM POJO, imamo samo jednu vrednost koju prosledjujemo ,jedan key 
		req2=given().log().all().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	}
		
}
