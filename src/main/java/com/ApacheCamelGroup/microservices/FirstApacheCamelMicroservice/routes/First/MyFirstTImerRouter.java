package com.ApacheCamelGroup.microservices.FirstApacheCamelMicroservice.routes.First;

import java.time.LocalDateTime;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyFirstTImerRouter extends RouteBuilder {
	
	@Autowired
	private GetCurrentTimeBean getCurrentTimeBean;
	
	@Autowired
	private SimpleLoggingProcessingComponent loggingProcessingComponent;

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		//queue -  listening to a queue & its input (for tutorial purposes we will utilise a timer)
		//transformation - making changes to the message that comes in from the queue 
		//database - save the transformed message ( for tutorial purposes we will utilise logs)
		from("timer:first-timer")
		
		.bean(getCurrentTimeBean)
		.log("${body}")
		// Route Ops - Processing & Transformation
		.bean(loggingProcessingComponent)
		.log("${body}")
		.to("log:first-timer");
	}
	
}

@Component
class GetCurrentTimeBean {
  public String getCurrentTime() {
	  return "issa Holiday => " + LocalDateTime.now();
  }
}

@Component
class SimpleLoggingProcessingComponent {
	
	private Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessingComponent.class);
	// Using a bean process with void mean we are doing some kind of processing in here.
	public void process(String message) {
		logger.info("SimpleLoggingProcessingComponent {}", message);
	}
}


