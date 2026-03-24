package stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import pageObject.ProductsAPI;


public class Products {
	
	public RequestSpecification httpRequest;
	public Response response;
	public int responsecode;
	
	ProductsAPI api = new ProductsAPI();
	public JSONObject requestParams;

	@Given("the GET products API endpoint is available")
	public void the_get_products_api_endpoint_is_available() {
		
	    RestAssured.baseURI = "https://fakestoreapi.com/";
	   
	}

	@When("the request is sent to the endpoint")
	public void the_request_is_sent_to_the_endpoint() {
		httpRequest = RestAssured.given();
	    response = httpRequest.get("/products");
	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer int1) {
	    responsecode = response.getStatusCode();
	    assertEquals(responsecode, 200);
	}
	
	
	@Given("hit the url of the add product api endpoint")
	public void hit_the_url_of_the_add_product_api_endpoint() {
		api.calluri();
	}

	@When("add products url is passed in the request")
	public void add_products_url_is_passed_in_the_request() {
		requestParams = new JSONObject();
	}

	@SuppressWarnings("unchecked")
	@When("pass the request body with product Title {string}")
	public void pass_the_request_body_with_product_title_product_title(String title) {
	api.buildReq(title);
	
	}
		
	@Then("verify whether the response status code is {int}")
	public void verify_whether_the_response_status_code_is(Integer int1) {
		responsecode = response.getStatusCode();
		assertEquals(responsecode, 201);
	}

}
