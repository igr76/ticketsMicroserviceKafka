package com.example.stmlabs.service.impl;

import com.example.stmlabs.dto.TicketDto;
import com.example.stmlabs.model.Ticket;
import com.example.stmlabs.service.TicketService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
@Service
public class TicketServiceImpl implements TicketService {

    @Override
    public Collection<Ticket> getAllTicket(LocalDateTime dateTime, String point, String nameCarrier) {
        return null;
    }

    @Override
    public void purchaseTicket(int id, Authentication authentication) {

    }

    @Override
    public Collection<Ticket> getAllMyPurchaseTicket(String login) {
        return null;
    }

    @Override
    public TicketDto greatTicket(TicketDto ticketDto, Authentication authentication) {
        return null;
    }

    @Override
    public TicketDto updateTicket(TicketDto ticketDto, Authentication authentication) {
        return null;
    }

    @Override
    public void deleteTicket(int id) {

    }
}
