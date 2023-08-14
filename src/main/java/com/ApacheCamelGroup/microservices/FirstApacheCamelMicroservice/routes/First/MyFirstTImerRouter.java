package com.ApacheCamelGroup.microservices.FirstApacheCamelMicroservice.routes.First;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyFirstTImerRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		//queue -  listening to a queue & its input (for tutorial purposes we will utilise a timer)
		//transformation - making changes to the message that comes in from the queue 
		//database - save the tranformed message ( for tutorial purposes we will utilise logs)
		from("timer:first-timer")
		.to("log:first-timer");
	}
	
}











