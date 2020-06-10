package com.grantlee289.springcamel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

  @Value("${endpoint.from}")
  private String fromEndpoint;

  public String getFromEndpoint() {
    return fromEndpoint;
  }
}
