package com.example.stmlabs.service.impl;

import com.example.stmlabs.dto.CarrierDto;
import com.example.stmlabs.service.CarrierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarrierServiceImpl implements CarrierService {
    @Override
    public CarrierDto greateCarrier(CarrierDto carrierDto, Authentication authentication) {
        return null;
    }

    @Override
    public CarrierDto updateCarrier(CarrierDto carrierDto, Authentication authentication) {
        return null;
    }

    @Override
    public void deleteCarrier(int id) {

    }
}
