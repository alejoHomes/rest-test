package com.nisum.ahomes.weather.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataPeerHour {

	@XmlElement(name = "date")
	public String date;

	@XmlElement(name = "hour_data")
	public String hour;

	@XmlElement(name = "temperature")
	public String temperature;

	@XmlElement(name = "text")
	public String text;

	@XmlElement(name = "humidity")
	public String humidity;

	public DataPeerHour(){}

	public DataPeerHour(String date, String hour, String temperature, String humidity, String text){
		this.setDate(date);
		this.setHour(hour);
		this.setText(text);
		this.setTemperature(temperature);
		this.setHumidity(humidity);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public void printerData(){
		System.out.print("Datas peer hour\t");
		System.out.print("Date: " + this.date );
		System.out.print("\tHour: " + this.hour );
		System.out.print("\tTemp: " + this.temperature );
		System.out.println("\tHumidity: " + this.humidity );
	}

	public String getDataJson2(Long id){
		return "{" +
				"\"id\":" + id +
                ",\"date\":\"" + this.getDate()  + "\"" +
                ", \"hour\":\"" + this.getHour()  + "\""+
                ", \"temp\":\"" + this.getTemperature()  + "\""+
                ", \"humidity\":\"" + this.getHumidity()  + "\""+
                "}";
	}



}
