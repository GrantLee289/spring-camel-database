package com.grantlee289.springcamel.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usermessages", schema = "microservicesdb")
public class UserMessage {

  @Id
  @Column(name = "ID")
  private int id;

  @Column(name = "Name")
  private String name;

  @Column(name = "Message")
  private String message;

  public UserMessage() {}

  public UserMessage(String name, String message) {
    this.name = name;
    this.message = message;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "Message: " + message + " from user: " + name + "(" + id + ")";
  }
}
