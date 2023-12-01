package com.emse.spring.automacorp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SP_HEATER")
public class HeaterEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, name = "Name")
    private String name;

    @ManyToOne(optional = false)
    private RoomEntity roomEntity;

    @OneToOne(optional = false)
    private SensorEntity status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public RoomEntity getRoom() {
        return roomEntity;
    }

    public SensorEntity getStatus() {
        return status;
    }

    public HeaterEntity(long id, String name, RoomEntity roomEntity, SensorEntity status) {
        this.id = id;
        this.name = name;
        this.roomEntity = roomEntity;
        this.status = status;
    }

    public HeaterEntity(String name, SensorEntity status, RoomEntity roomEntity) {
        this.name = name;
        this.status = status;
        this.roomEntity = roomEntity;
    }

    public HeaterEntity() {}
}
