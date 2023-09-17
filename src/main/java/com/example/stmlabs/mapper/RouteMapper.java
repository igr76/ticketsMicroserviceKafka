package com.example.stmlabs.mapper;


import com.example.stmlabs.dto.RouteDto;
import com.example.stmlabs.model.Route;
import org.mapstruct.Mapper;
/**
 * маппер для {@link Route} готовый dto {@link RouteDto}
 */
@Mapper(componentModel = "spring")
public interface RouteMapper {
    Route toEntity(RouteDto routeDto);
    RouteDto toDTO(Route route);
}
