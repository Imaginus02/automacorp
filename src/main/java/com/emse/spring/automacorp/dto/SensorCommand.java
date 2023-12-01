package com.emse.spring.automacorp.dto;

import com.emse.spring.automacorp.model.SensorEntity;

public record SensorCommand(String name, Double value, SensorEntity.SensorType sensorType) {
}