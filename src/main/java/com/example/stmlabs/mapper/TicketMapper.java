package com.example.stmlabs.mapper;


import com.example.stmlabs.dto.TicketDto;
import com.example.stmlabs.model.Ticket;
import org.mapstruct.Mapper;
/**
 * маппер для {@link Ticket} готовый dto {@link TicketDto}
 */
@Mapper(componentModel = "spring")
public interface TicketMapper {
    Ticket toEntity(TicketDto ticketDto);
    TicketDto toDTO(Ticket ticket);
}
