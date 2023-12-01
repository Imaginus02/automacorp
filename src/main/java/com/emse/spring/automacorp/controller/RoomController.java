package com.emse.spring.automacorp.controller;

import com.emse.spring.automacorp.dao.RoomDao;
import com.emse.spring.automacorp.dao.SensorDao;
import com.emse.spring.automacorp.dao.WindowDao;
import com.emse.spring.automacorp.dto.Room;
import com.emse.spring.automacorp.dto.RoomCommand;
import com.emse.spring.automacorp.mapper.RoomMapper;
import com.emse.spring.automacorp.model.RoomEntity;
import com.emse.spring.automacorp.model.SensorEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    private final WindowDao windowDao;
    private final RoomDao roomDao;
    private final SensorDao sensorDao;

    public RoomController(WindowDao windowDao, RoomDao roomDao, SensorDao sensorDao) {this.windowDao = windowDao; this.roomDao = roomDao; this.sensorDao=sensorDao;}


    @GetMapping
    public List<Room> findAll() {
        return roomDao.findAll()
                .stream()
                .map(RoomMapper::of)
                .sorted(Comparator.comparing(Room::name))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Room> create(@RequestBody RoomCommand room) {
        SensorEntity sensor = new SensorEntity(SensorEntity.SensorType.TEMPERATURE,"Temperature sensor of "+room.name());
        sensorDao.save(sensor);
        RoomEntity entity = new RoomEntity(room.name(),sensor, room.floor());
        RoomEntity saved = roomDao.save(entity);
        return ResponseEntity.ok(RoomMapper.of(saved));
    }
}
