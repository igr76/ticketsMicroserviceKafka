package com.example.stmlabs.service;

import com.example.stmlabs.dto.CarrierDto;
import org.springframework.security.core.Authentication;

public interface CarrierService {
    CarrierDto greateCarrier(CarrierDto carrierDto, Authentication authentication);
    CarrierDto updateCarrier(CarrierDto carrierDto,Authentication authentication);
    void deleteCarrier(int id);
}
