package com.emse.spring.automacorp.mapper;

import com.emse.spring.automacorp.dto.Building;
import com.emse.spring.automacorp.model.BuildingEntity;

import java.util.stream.Collectors;

public class BuildingMapper {
    public static Building of(BuildingEntity building) {
        return new Building(
                building.getId(),
                building.getName(),
                building.getExteriorTemperature(),
                building.getRoomEntitySet().stream().map(RoomMapper::of).collect(Collectors.toList())
        );
    }
}
