package com.example.stmlabs.mapper;

import com.example.stmlabs.dto.CarrierDto;
import com.example.stmlabs.model.Carrier;
import org.mapstruct.Mapper;
/**
 * маппер для {@link com.example.stmlabs.model.Carrier} готовый dto {@link com.example.stmlabs.dto.CarrierDto}
 */
@Mapper(componentModel = "spring")
public interface CarrierMapper {
    Carrier toEntity(CarrierDto carrierDto);
    CarrierDto toDTO(Carrier carrier);
}
