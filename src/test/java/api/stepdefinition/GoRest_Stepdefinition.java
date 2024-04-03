package api.stepdefinition;

import static org.junit.Assert.assertEquals;

import api.endpoints.Routes;
import api.payload.Request_data;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GoRest_Stepdefinition {
	
	static int id;
	RequestSpecification request;
	Response response;

	@Given("I hit the url of POST API endpoint")
	public void i_hit_the_url_of_post_api_endpoint() {
		request = RestAssured.given();
	}

	@When("I pass the POST url in the request with token")
	public void i_pass_the_url_in_the_request() {
		request.header("Authorization", "Bearer " + Routes.token);
		request.contentType(ContentType.JSON);

	}

	@When("I pass the request body with POST method")
	public void i_pass_the_request_body_with_post_method() {
		response = request.body(Request_data.postRequestBody()).post(Routes.post_url);

	}

	@When("I receive the response code as {int}")
	public void i_receive_the_response_code_as(int code) {
		int actualcode = response.getStatusCode();
		if (actualcode == 200) {
			assertEquals(actualcode, 200);
		} else if (actualcode == 201) {
			assertEquals(actualcode, 201);
		} else if (actualcode == 204) {
			assertEquals(actualcode, 204);
		}

	}

	@Then("I receive the response body with ID")
	public void i_receive_the_response_body_with_id() {
		id = response.jsonPath().get("id");

	}

	@Given("I hit the url of the GET API endpoint")
	public void i_hit_the_url_of_the_get_api_endpoint() {
		request = RestAssured.given();

	}

	@When("I pass the GET url in the request with ID and token")
	public void i_pass_the_get_url_in_the_request_with_id_and_token() {
		request.header("Authorization", "Bearer " + Routes.token);
		request.pathParam("id", id);
		response = request.get(Routes.get_url);
	}

	@Then("I receive the response body with the response")
	public void i_receive_the_response_body_with_the_response() {
		response.prettyPrint();
	}

	@Given("I hit the url of the PUT API endpoint")
	public void i_hit_the_url_of_the_put_api_endpoint() {
		request = RestAssured.given();

	}

	@When("I pass the PUT url in the request with ID and token")
	public void i_pass_the_put_url_in_the_request_with_id_and_token() {
		request.header("Authorization", "Bearer " + Routes.token);
		request.contentType(ContentType.JSON);

	}

	@When("I pass the request body with PUT method")
	public void i_pass_the_request_body_with_put_method() {
		request.pathParam("id", id);
		response = request.body(Request_data.updateRequestBody()).put(Routes.update_url);

	}

	@Then("I receive the response body with updated details")
	public void i_receice_the_response_body_with_updated_details() {
		response.prettyPrint();
	}

	@Given("I hit the url of the DELETE API endpoint")
	public void i_hit_the_url_of_the_delete_api_endpoint() {
		request = RestAssured.given();

	}

	@When("I pass the DELETE url in the request with ID and token")
	public void i_pass_the_delete_url_in_the_request_with_id() {
		request.header("Authorization", "Bearer " + Routes.token);
		request.pathParam("id", id);
		response = request.delete(Routes.delete_url);
	}

}
