package com.example.stmlabs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Cущность перевозчик  */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carrier {

  private long id;
  private String name;
  private String phone;


}
