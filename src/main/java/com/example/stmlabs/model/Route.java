package com.example.stmlabs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Cущность маршрут  */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Route {

  private long id;
  private String arrivalPoint;
  private String departurePoint;
  private Carrier carrier;
  private int durationInMinutes;


}
