package Starwars;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StarWars {
	@Test
	public void starWarsResponse() {
		
		baseURI = "https://swapi.dev/api/people";
		get(baseURI).then().statusCode(200).body("count", equalTo(82));
		Response response  = get(baseURI);
		JsonPath js = new JsonPath(response.asString());
		List<String> names = js.get("results.name");
		for(String name : names ) {
			System.out.println(name);
		}
	}

}
