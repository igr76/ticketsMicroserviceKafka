package com.example.stmlabs.dto;

import com.example.stmlabs.model.Route;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/** Cущность билет  */
public class TicketDto {

  private long id;
  private Route route;
  private LocalDateTime dateTime;
  private int place;
  private int cost;


}
