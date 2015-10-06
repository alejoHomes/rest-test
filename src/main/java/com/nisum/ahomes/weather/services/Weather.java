package com.nisum.ahomes.weather.services;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@XmlRootElement(name = "data")
public class Weather {

	Gson gson = new GsonBuilder().create();

	@XmlElement(name ="locality")
	public Locality locality;

	@XmlElement(name = "hour_hour")
	public DataList dataList;

	public void printDatas(){
		System.out.println("Weather city: " + locality.getCity());
		System.out.println("Weather country: " +locality.getCountry());
		dataList.printDatas();
	}

	public String getLocality(){
		return gson.toJson(locality);
	}

	public String getWeather(String date, String hour ){
		return gson.toJson(dataList.getDatasList(date, hour));
	}

	public String getWeather( ){
		return gson.toJson(dataList);
	}

	public String deleteWeather(String date, String hour){
		return dataList.deleteDatasList(date, hour);
	}




}
