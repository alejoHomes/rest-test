# SYNOPSIS
Spring Rest - weather project version 1.0

tags: Spring Rest, MVC, Json, jUnit, gradle, jenkins

This project is created using java and a spring rest service. 
For testing was used jUnit.
Build with gradle.


## The service
This project has two service:
* One is a XML consumes, the consumes its form a weather page, the datas stored in object.
* Other its a Json producer from the datas queryed in the XML consumes. 

Use cases:

### seturi?uri=[some uri]
http://localhost:8080/seturi?uri=http://xml.tutiempo.net/xml/55660.xml?lan=en
Set the uri of the XML consume
if this its not seter, the default uri is from Santiago de Chile.

### locality
http://localhost:8080/locality
Produce a Json response with the city and country of the weather datas

### weather?date=[date]&hour=[hour]
http://localhost:8080/weather?date=2015-10-2&hour=23:00
Show the weather data form the date and hour expecify. 
NOTE: the XML consume, response with 24 hour from the moment to the query, so, only response with this rage of time.

    
## Build
* Default build. Run test and bootRun
		
		$ gradle

* To build and run the testing cases.
        
        $ gradle test

* To run the Rest services.

		$ gradle bootRun

