package com.nisum.ahomes.weather.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.ahomes.weather.services.GetXmlObject;
import com.nisum.ahomes.weather.services.Greeting;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@RestController
public class Controller {

	String uri = "http://xml.tutiempo.net/xml/55760.xml?lan=en";

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public void setUri(String uri){
    	this.uri = uri;
    }

 	public void InitXmlRequest(){
 		if (uri == null) setUri("http://xml.tutiempo.net/xml/55760.xml?lan=en");
		GetXmlObject.run(uri);
	}

	@RequestMapping(value = "/seturi", method = POST, produces = "application/json")
	@ResponseBody
	public String set(@RequestParam(value="uri")  String uri){
		this.uri = uri;
		return "{\"text\":\"uri seted\"}";
	}

    @RequestMapping(value = "/greeting", method = GET, produces = "application/json")
    @ResponseBody
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping(value = "/locality", method = GET, produces = "application/json")
    @ResponseBody
    public String locality(){
    	if (GetXmlObject.weather == null) this.InitXmlRequest();
    	return GetXmlObject.weather.getLocality();
    }

    @RequestMapping(value = "/weather", method = GET, produces = "application/json")
    @ResponseBody
    public String weather(@RequestParam(value="date")  String date, @RequestParam(value="hour") String hour){
    	if (GetXmlObject.weather == null) this.InitXmlRequest();
    	if (!GetXmlObject.weather.getWeather(date,hour).isEmpty() )
    		return GetXmlObject.weather.getWeather(date,hour);
    	else
    		return "{\"text\":\"adjflasdhfljsdfhñ\"}";
    }

    @RequestMapping(value = "/weather/list", method = GET, produces = "application/json")
    @ResponseBody
    public String list(){
    	if (GetXmlObject.weather == null) this.InitXmlRequest();
    	return GetXmlObject.weather.getWeather();
    }

    @RequestMapping(value = "/delete", method = DELETE, produces = "application/json")
    @ResponseBody
    public String delete(@RequestParam(value="date")  String date, @RequestParam(value="hour") String hour){
    	if (GetXmlObject.weather == null) this.InitXmlRequest();
    	return GetXmlObject.weather.deleteWeather(date,hour);
    }

}
