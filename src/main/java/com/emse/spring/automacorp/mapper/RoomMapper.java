package com.emse.spring.automacorp.mapper;

import com.emse.spring.automacorp.dto.Room;
import com.emse.spring.automacorp.model.RoomEntity;

import java.util.stream.Collectors;

public class RoomMapper {
    public static Room of(RoomEntity roomEntity) {
        return new Room(
                roomEntity.getId(),
                roomEntity.getName(),
                roomEntity.getFloor(),
                SensorMapper.of(roomEntity.getCurrentTemperature()),
                roomEntity.getTargetTemperature(),
                roomEntity.getBuilding().getId(),
                roomEntity.getWindowEntitySet().stream().map(WindowMapper::of).collect(Collectors.toList()),
                roomEntity.getHeaterEntitySet().stream().map(HeaterMapper::of).collect(Collectors.toList()),
                roomEntity.getAdjacentRooms().stream().map(RoomEntity::getId).collect(Collectors.toList())
        );
    }
}
