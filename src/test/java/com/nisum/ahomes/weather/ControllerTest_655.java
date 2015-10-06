package com.nisum.ahomes.weather;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.startsWith;

import java.util.Calendar;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.nisum.ahomes.weather.controller.Controller;

public class ControllerTest_655 {

	@Before
	public void setUpGreeting() throws Exception {
		RestAssuredMockMvc.standaloneSetup(new Controller());
	}

    @AfterClass
    public static void resetRestAssured() {
        RestAssuredMockMvc.reset();
    }

    /**
     *  Task #655
     * AC1: Get a greeting pass.
	 * Given: Parameter like name = "Alejandro".
	 * When: I pass the request to the REST service by GET method.
	 * Then: I get the Status OK, and a json Path with id = "1" and content = "Hello Alejandro!".
     */
	@Test
	public void get_a_greeting_pass() {
		given().
	    		param("name", "Alejandro").
		when().
	            get("/greeting").
	    then().
	    		statusCode(200).
	            body("id", equalTo(1)).
	            body("content", equalTo("Hello, Alejandro!"));
	}

	/**
	 * Task #655
	 * AC2: Get a greeting failure.
	 * Given: Parameter like name = "Alejandro".
	 * When: I pass the request to the REST service by POST method.
	 * Then: I get a request method not supported, with a Status Code 405.
	 */
	@Test
	public void get_a_greeting_failure() {
		given().
				param("name", "Alejandro").
		when().
	    		post("/greeting").
	    then().
	    		statusCode(405);
	}



	/**
	 * Task #655
	 * AC3: Get weather data by date & hour.
	 * Given: the user request "../weather{date&hour}"
	 * When: I pass the request to the REST service by GET method.
	 * Then: I get the data witch the date in XML/JSON format.
	 */
	@Test
	public void get_weather_data_by_date_and_hour(){

		Calendar calendar = Calendar.getInstance();
		String date = Integer.toString(calendar.get(Calendar.YEAR))+"-"+Integer.toString(calendar.get(Calendar.MONTH)+1)+"-"+Integer.toString(calendar.get(Calendar.DATE));
		String hour = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY)+1)+":00";

		given().
			param("date",date).
			param("hour",hour).
		when().
			get("/weather").
		then().
			statusCode(200).
			body("hour", contains(hour)).
			body("date", contains(date));

	}

	/**
	 * Task #655
	 * AC4: Get a list of weather data:
	 * Given: the user request "../weather/list"
	 * When: I pass the request to the REST Service by GET method.
	 * Then: I get a list of weather data in XML/JSON format.
	 */
	@Test
	public void get_a_list_of_weather_date(){
		given().
			get("/weather/list").
		then().
			statusCode(200).
			body(notNullValue());
	}

	/**
	 * Task #655
	 *  AC5: Delete data by date & hour
	 * Given: the param date and hour.
	 * When: I pass the request to the REST Service by DELETE method.
	 * Then: I delete the data with the corresponding id
	 * And: I get a XML/JSON message of SUCCESS.
	 */
	@Test
	public void delete_data_by_date_and_hour(){

		Calendar calendar = Calendar.getInstance();
		String date = Integer.toString(calendar.get(Calendar.YEAR))+"-"+Integer.toString(calendar.get(Calendar.MONTH)+1)+"-"+Integer.toString(calendar.get(Calendar.DATE));
		String hour = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY)+1)+":00";

		given().
			param("date", date).
			param("hour", hour).
		when().
			delete("/delete").
		then().
			statusCode(200).
			body("text", startsWith("deleted data"));
	}

	/**
	 * Task #655
	 * AC6: Create a new data
	 * Given: the user request ".../weather/create"
	 * And: and the XML/JSON object with the data
	 * When: I pass the request to the REST Service by POST method.
	 * Then: I get a XML/JSON message of SUCCESS.
	 */

	public void create_new_data(){
		Calendar calendar = Calendar.getInstance();
		String date = Integer.toString(calendar.get(Calendar.YEAR))+"-"+Integer.toString(calendar.get(Calendar.MONTH)+1)+"-"+Integer.toString(calendar.get(Calendar.DATE)+1);
		String hour = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY)+1)+":00";

		given().
			param("date", date).
			param("hour", hour).
		when().
			delete("/create").
		then().
			statusCode(200).
			body("text", startsWith("created data"));
	}


}