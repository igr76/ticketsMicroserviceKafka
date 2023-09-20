package com.example.stmlabs.service;

import com.example.stmlabs.dto.RouteDto;
import org.springframework.security.core.Authentication;

public interface RouteService {
    RouteDto greateRoute(RouteDto routeDto, Authentication authentication);
    RouteDto updateRoute(RouteDto routeDto, Authentication authentication);
    void deleteRoute(int id);
}
