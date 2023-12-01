package com.emse.spring.automacorp.controller;

import com.emse.spring.automacorp.dao.BuildingDao;
import com.emse.spring.automacorp.dao.RoomDao;
import com.emse.spring.automacorp.dao.SensorDao;
import com.emse.spring.automacorp.dao.WindowDao;
import com.emse.spring.automacorp.dto.Building;
import com.emse.spring.automacorp.mapper.BuildingMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/building")
@Transactional
public class BuildingController {

    private final WindowDao windowDao;
    private final RoomDao roomDao;
    private final SensorDao sensorDao;
    private final BuildingDao buildingDao;

    public BuildingController(WindowDao windowDao, RoomDao roomDao, SensorDao sensorDao, BuildingDao buildingDao) {
        this.windowDao = windowDao;
        this.roomDao = roomDao;
        this.sensorDao = sensorDao;
        this.buildingDao = buildingDao;
    }

    @GetMapping
    public List<Building> findAll() {
        return buildingDao.findAll()
                .stream()
                .map(BuildingMapper::of)
                .collect(Collectors.toList());
    }
}
