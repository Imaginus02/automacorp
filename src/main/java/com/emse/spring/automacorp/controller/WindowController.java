package com.emse.spring.automacorp.controller;

import com.emse.spring.automacorp.dao.RoomDao;
import com.emse.spring.automacorp.dao.SensorDao;
import com.emse.spring.automacorp.dao.WindowDao;
import com.emse.spring.automacorp.dto.Window;
import com.emse.spring.automacorp.dto.WindowCommand;
import com.emse.spring.automacorp.mapper.SensorMapper;
import com.emse.spring.automacorp.mapper.WindowMapper;
import com.emse.spring.automacorp.model.SensorEntity;
import com.emse.spring.automacorp.model.WindowEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/windows")
@Transactional
public class WindowController {

    private final WindowDao windowDao;
    private final RoomDao roomDao;
    private final SensorDao sensorDao;

    public WindowController(WindowDao windowDao, RoomDao roomDao, SensorDao sensorDao) {this.windowDao = windowDao; this.roomDao = roomDao; this.sensorDao=sensorDao;}

    @GetMapping
    public List<Window> findAll() {
        return windowDao.findAll()
                .stream()
                .map(WindowMapper::of)
                .sorted(Comparator.comparing(Window::name))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public Window findById(@PathVariable Long id) {
        return windowDao.findById(id).map(WindowMapper::of).orElse(null);
    }

    @PostMapping
    public ResponseEntity<Window> create(@RequestBody WindowCommand window) {
        System.out.println(window.name());
        System.out.println(window.roomId());
        SensorEntity sensor = new SensorEntity(SensorEntity.SensorType.STATUS,"Sensor of "+window.name()+" of room "+window.roomId());
        sensorDao.save(sensor);
        WindowEntity entity = new WindowEntity(window.name(), sensor, roomDao.findById(window.roomId()).orElse(null));
        WindowEntity saved = windowDao.save(entity);
        return ResponseEntity.ok(WindowMapper.of(saved));
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {windowDao.deleteById(id);}

    @PatchMapping(path = "/{id}/switch")
    public ResponseEntity<Window> patch(@PathVariable Long id) {
        WindowEntity windowEntity = windowDao.findById(id).orElse(null);
        if (windowEntity == null) {
            return ResponseEntity.badRequest().build();
        }
        windowEntity.switchStatus();
        return ResponseEntity.ok(WindowMapper.of(windowEntity));
    }
}
