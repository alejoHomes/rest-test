package com.nisum.ahomes.helloworld;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import hello.GreetingController;

public class ControllerTest {

	MockMvc mockMvc;

	@Before
	public void setUpGreeting() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(new GreetingController()).build();
	}

/*
	@Test
	public void  sayHello() throws Exception {
        mockMvc.perform(
        		get("/greeting").content("Hello World")
        		);
    }
*/
}
