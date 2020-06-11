package com.grantlee289.springcamel.routes;

import com.grantlee289.springcamel.config.ApplicationProperties;
import com.grantlee289.springcamel.dao.UserMessageRepository;
import com.grantlee289.springcamel.processors.ProcessToDb;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ReceiverRoute extends RouteBuilder {

  private ApplicationProperties applicationProperties;

  private UserMessageRepository userMessageRepository;

  public ReceiverRoute(ApplicationProperties applicationProperties, UserMessageRepository userMessageRepository) {
    this.applicationProperties = applicationProperties;
    this.userMessageRepository = userMessageRepository;
  }

  @Override
  public void configure() throws Exception {
    from(applicationProperties.getFromEndpoint())
        .log(LoggingLevel.INFO, "Received Message: \n ${body}")
        .process(new ProcessToDb(userMessageRepository))
        .log(LoggingLevel.INFO, "Message Successfully Processed!")
        .end();
  }
}
