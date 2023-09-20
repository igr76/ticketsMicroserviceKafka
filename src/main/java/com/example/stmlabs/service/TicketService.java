package com.example.stmlabs.service;

import com.example.stmlabs.dto.TicketDto;
import com.example.stmlabs.model.Ticket;
import org.springframework.security.core.Authentication;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

public interface TicketService {
    /**
     * @param dateTime
     * @param point
     * @param nameCarrier
     * @return
     */
    Collection<Ticket> getAllTicket(LocalDateTime dateTime,
                                    String point, String nameCarrier);
    void purchaseTicket(int id, Authentication authentication);
    Collection<Ticket> getAllMyPurchaseTicket(String login);
    TicketDto greatTicket(TicketDto ticketDto, Authentication authentication);
    TicketDto updateTicket(TicketDto ticketDto,Authentication authentication);
    void  deleteTicket(int id);
    }
