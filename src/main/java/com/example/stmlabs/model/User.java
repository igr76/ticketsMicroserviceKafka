package com.example.stmlabs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Cущность пассажир  */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private long id;
  private String login;
  private String passwordHash;
  private String name;
  private String surname;
  private String patronymicName;


}
