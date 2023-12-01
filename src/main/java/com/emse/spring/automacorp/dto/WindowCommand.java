package com.emse.spring.automacorp.dto;
import com.emse.spring.automacorp.model.RoomEntity;
import com.emse.spring.automacorp.model.SensorEntity;
import com.emse.spring.automacorp.model.WindowEntity;
public record WindowCommand(String name, Long roomId) {
}
