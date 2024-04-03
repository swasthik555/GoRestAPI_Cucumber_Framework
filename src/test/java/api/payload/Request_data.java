package api.payload;

import java.util.HashMap;

import com.github.javafaker.Faker;

public class Request_data {
	
static Faker faker = new Faker();
	
	public static Object postRequestBody() {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", faker.name().name());
		data.put("gender", "male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		return data;
	}
	
	public static Object updateRequestBody() {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", faker.name().name());
		data.put("gender", "female");
		data.put("email", faker.internet().emailAddress());
		
		return data;
	}

}
