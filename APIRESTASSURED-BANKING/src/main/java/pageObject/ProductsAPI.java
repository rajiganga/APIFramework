package pageObject;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProductsAPI {
	
	public RequestSpecification httpRequest;
	public  Response response;
	public int responsecode;
	
	
	public static JSONObject requestParams;

	public static void calluri() {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://fakestoreapi.com/";
	}

	@SuppressWarnings("unchecked")
	public void buildReq(String title) {
		requestParams.put("title", title);
	    requestParams.put("price", "4.0");
	    requestParams.put("description", "Puma Running Shoes for women");
	    requestParams.put("Brand", "Puma");
	
		response = RestAssured
		    .given()
		    .contentType("application/JSON")
		    .body(requestParams.toJSONString())
            .post("products");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
	}
	
	

}
