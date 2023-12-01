package com.emse.spring.automacorp.dto;

import com.emse.spring.automacorp.model.SensorEntity;

import java.util.List;

public record Building(Long id, String name, SensorEntity sensorEntity, List<Room> roomList) {
}
