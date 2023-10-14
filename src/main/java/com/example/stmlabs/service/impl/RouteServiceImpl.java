package com.example.stmlabs.service.impl;

import com.example.stmlabs.dto.RouteDto;
import com.example.stmlabs.service.RouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class RouteServiceImpl implements RouteService {
    @Override
    public RouteDto greateRoute(RouteDto routeDto, Authentication authentication) {
        return null;
    }

    @Override
    public RouteDto updateRoute(RouteDto routeDto, Authentication authentication) {
        return null;
    }

    @Override
    public void deleteRoute(int id) {

    }
}
