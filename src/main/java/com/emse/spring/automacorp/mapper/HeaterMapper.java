package com.emse.spring.automacorp.mapper;

import com.emse.spring.automacorp.dto.Heater;
import com.emse.spring.automacorp.model.HeaterEntity;

public class HeaterMapper {
    public static Heater of(HeaterEntity heater) {
        return new Heater(
                heater.getId(),
                heater.getName(),
                heater.getRoom().getId(),
                SensorMapper.of(heater.getStatus())
        );
    }
}
