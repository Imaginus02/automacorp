package com.emse.spring.automacorp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SP_WINDOW")
public class WindowEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    private SensorEntity windowStatus;


    @ManyToOne(optional = false)
    private RoomEntity room;

    public WindowEntity() {
    }

    public WindowEntity(String name, SensorEntity windowStatus, RoomEntity roomEntity) {
        this.name = name;
        this.windowStatus = windowStatus;
        this.room = roomEntity;
    }


    public WindowEntity(long id,String name, SensorEntity sensor, RoomEntity roomEntity) {
        this.id = id;
        this.windowStatus = sensor;
        this.name = name;
        this.room = roomEntity;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SensorEntity getWindowStatus() {
        return windowStatus;
    }

    public void setWindowStatus(SensorEntity windowStatus) {
        this.windowStatus = windowStatus;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public void switchStatus() {

        if (this.windowStatus.getValue() == 1.0) {
            this.windowStatus.setValue(0.0);
        } else {
            this.windowStatus.setValue(1.0);
        }
    }
}
