package com.emse.spring.automacorp.mapper;

import com.emse.spring.automacorp.dto.Heater;
import com.emse.spring.automacorp.dto.Room;
import com.emse.spring.automacorp.dto.Sensor;
import com.emse.spring.automacorp.dto.Window;
import com.emse.spring.automacorp.model.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class RoomMapperTest {

//    @Test
//    void shouldMapRoom() {
//        // Arrange
//        SensorEntity currentTemperature = new SensorEntity(SensorEntity.SensorType.TEMPERATURE, "Room temperature");
//        currentTemperature.setId(1L);
//        currentTemperature.setValue(24.2);
//
//        RoomEntity roomEntity = new RoomEntity("Room", currentTemperature, 1);
//        roomEntity.setId(1L);
//        roomEntity.setTargetTemperature(22.0);
//
//        SensorEntity windowStatus = new SensorEntity(SensorEntity.SensorType.STATUS, "Window status");
//        windowStatus.setId(2L);
//        windowStatus.setValue(0.0);
//
//        WindowEntity windowEntity = new WindowEntity("Window 1", windowStatus, roomEntity);
//        windowEntity.setId(2L);
//        roomEntity.setWindowEntitySet(Set.of(windowEntity));
//
//        SensorEntity heaterStatus = new SensorEntity(3L, "Heater status", 0.0, SensorEntity.SensorType.STATUS);
//        HeaterEntity heaterEntity = new HeaterEntity("Heater 1", heaterStatus, roomEntity);
//        heaterEntity.setId(1L);
//        roomEntity.setHeaterEntitySet(Set.of(heaterEntity));
//
//        SensorEntity exteriorTemperature = new SensorEntity(4L, "Building 1 exterior temperature", 14.0, SensorEntity.SensorType.TEMPERATURE);
//        BuildingEntity buildingEntity = new BuildingEntity(1L,"Building 1", exteriorTemperature);
//        roomEntity.setBuilding(buildingEntity);
//
//        // Act
//        Room room = RoomMapper.of(roomEntity);
//
//        // Assert
//        Room expectedRoom = new Room(
//                1L,
//                "Room",
//                1,
//                new Sensor(1L, "Room temperature", 24.2, SensorEntity.SensorType.TEMPERATURE),
//                22.0,
//                1L,
//                List.of(new Window(
//                        2L,
//                        "Window 1",
//                        new Sensor(2L, "Window status", 0.0, SensorEntity.SensorType.STATUS),
//                        1L
//                    )
//                ),
//                List.of(new Heater(
//                        1L,
//                        "Heater 1",
//                        1L,
//                        new Sensor( 3L, "Heater status", 0.0, SensorEntity.SensorType.STATUS)
//                    )
//                )
//        );
//        Assertions.assertThat(room).usingRecursiveAssertion().isEqualTo(expectedRoom);
//    }
}
