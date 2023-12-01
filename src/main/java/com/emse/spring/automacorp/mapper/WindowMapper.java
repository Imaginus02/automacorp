package com.emse.spring.automacorp.mapper;

import com.emse.spring.automacorp.dto.Window;
import com.emse.spring.automacorp.model.WindowEntity;

public class WindowMapper {
    public static Window of(WindowEntity window) {
        return new Window(
                window.getId(),
                window.getName(),
                SensorMapper.of(window.getWindowStatus()),
                window.getRoom().getId()
        );
    }
}
