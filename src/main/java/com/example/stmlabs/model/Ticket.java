package com.example.stmlabs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
/** Cущность билет  */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

  private long id;
  private Route route;
  private LocalDateTime dateTime;
  private int place;
  private int cost;


}
