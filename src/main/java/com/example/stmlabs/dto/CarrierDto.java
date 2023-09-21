package com.example.stmlabs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Cущность перевозчик  */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarrierDto {

  private long id;
  private String name;
  private String phone;


}
