package com.emse.spring.automacorp.dto;

import java.util.List;

public record Room(Long id, String name, int floor, Sensor currentTemperature, Double targetTemperature, Long buildingId, List<Window> windowList, List<Heater> heaterList, List<Long> adjacentRoomsId) {
}
