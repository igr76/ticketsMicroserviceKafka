package com.example.stmlabs.dto;

import com.example.stmlabs.model.Carrier;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Cущность маршрут  */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RouteDto {

  private long id;
  private String arrivalPoint;
  private String departurePoint;
  private Carrier carrier;
  private int durationInMinutes;


}
