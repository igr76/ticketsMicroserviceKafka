package com.example.stmlabs.repository;

import com.example.stmlabs.model.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.Collection;

public class TicketRepository {
    private  JdbcTemplate jdbcTemplate;

    void purchaseTicket(int id,int userId){jdbcTemplate.queryForObject("UPDATE `tickets` " +
            "SET `userId` = REPLACE(`userId`,0,:userId) WHERE Id=:id",Integer.class);}
    Collection<Ticket> getAllTicket(LocalDateTime dateTime, String point, String nameCarrier) {
       return jdbcTemplate.queryForObject("SELECT * FROM tickets JOIN route ON tickets.route = route.id  " +
               "JOIN carrier ON route.carrier = carrier.id WHERE tickets.dateTime= :dateTime AND route.arrivalPoint=:arrivalPoint AND" +
               "route.departurePoint=:departurePoint AND carrier.name=:nameCarrier",Collection.class);}

}
