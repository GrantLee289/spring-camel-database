package com.grantlee289.springcamel.routes;

import com.grantlee289.springcamel.config.ApplicationProperties;
import com.grantlee289.springcamel.processors.ProcessToDb;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.tomcat.jni.Proc;
import org.springframework.stereotype.Component;

@Component
public class ReceiverRoute extends RouteBuilder {

  private ApplicationProperties applicationProperties;

  public ReceiverRoute(ApplicationProperties applicationProperties) {
    this.applicationProperties = applicationProperties;
  }

  @Override
  public void configure() throws Exception {
    from(applicationProperties.getFromEndpoint())
        .log(LoggingLevel.INFO, "Received Message: \n ${body}")
        .process(new ProcessToDb())
        .log(LoggingLevel.INFO, "Message Successfully Processed!")
        .end();
  }
}
