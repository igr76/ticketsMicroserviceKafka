package com.example.stmlabs.model;

public class User {

  private long id;
  private String login;
  private String passwordHash;
  private String name;
  private String surname;
  private String patronymicName;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getPatronymicName() {
    return patronymicName;
  }

  public void setPatronymicName(String patronymicName) {
    this.patronymicName = patronymicName;
  }

}
