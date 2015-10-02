package com.nisum.ahomes.weather.services;

import org.springframework.web.client.RestTemplate;


public class GetXmlObject {

	public static Weather weather = null;

	public static void run(String uri) {

		RestTemplate restTemplate = new RestTemplate();
		weather = restTemplate.getForObject(uri, Weather.class);

//		weather.printDatas();

	}

}
