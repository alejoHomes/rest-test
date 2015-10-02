package com.nisum.ahomes.weather;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.nisum.ahomes.weather.controller.Controller;

public class ControllerTest_852 {

	@Before
	public void setUpGreeting() throws Exception {
		RestAssuredMockMvc.standaloneSetup(new Controller());
	}

    @AfterClass
    public static void resetRestAssured() {
        RestAssuredMockMvc.reset();
    }
	/**
	 * Task #852
	 * AC1: Create a POST request.
	 * Given: a url.
	 * When: I create a POST request.
	 * Then: I set the request Accept header and the result status is OK or 200.
	 */
	@Test
	public void create_a_POST_request(){
		//Santiago, Chile:  http://xml.tutiempo.net/xml/55760.xml?lan=en
		given().
			param("uri", "http://xml.tutiempo.net/xml/55760.xml?lan=en").
		when().
			post("/seturi").
		then().
			statusCode(200).
			body("text", equalTo("uri seted"));
	}

	/**
	 * Task #852
 	 * AC2: Read weather data:
	 * Given: A url and a created GET request.
	 * When: I map a XML element.
	 * Then: I have this element and a message of SUCCESS.
	 */
	@Test
	public void read_weather_data(){
		given().
			get("/locality").
		then().
			statusCode(200).
	        body("city", equalTo("Santiago")).
	        body("country", equalTo("Chile"));
	}



}