package com.emse.spring.automacorp.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "SP_BUILDING")
public class BuildingEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(optional = false)
    private SensorEntity exteriorTemperature;

    @OneToMany(mappedBy = "building")
    private Set<RoomEntity> RoomEntitySet = Set.of();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SensorEntity getExteriorTemperature() {
        return exteriorTemperature;
    }

    public Set<RoomEntity> getRoomEntitySet() {
        return RoomEntitySet;
    }

    public BuildingEntity() {
    }

    public BuildingEntity(long id, String name, SensorEntity exteriorTemperature) {
        this.id = id;
        this.name = name;
        this.exteriorTemperature = exteriorTemperature;
    }
}
