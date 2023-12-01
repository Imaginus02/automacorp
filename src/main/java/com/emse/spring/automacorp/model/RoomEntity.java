package com.emse.spring.automacorp.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "SP_ROOM")
public class RoomEntity {

    public Long getId() {
        return id;
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

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public SensorEntity getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(SensorEntity currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public Set<WindowEntity> getWindowEntitySet() {
        return windowEntitySet;
    }

    public void setWindowEntitySet(Set<WindowEntity> windowEntitySet) {
        this.windowEntitySet = windowEntitySet;
    }

    public Set<HeaterEntity> getHeaterEntitySet() {
        return this.heaterEntitySet;
    }

    public void setHeaterEntitySet(Set<HeaterEntity> heaterEntitySet) {
        this.heaterEntitySet = heaterEntitySet;
    }

    public BuildingEntity getBuilding() {
        return this.building;
    }

    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }

    public Set<RoomEntity> getAdjacentRooms() {
        return this.adjacentRooms;
    }

    public void setAdjacentRooms(Set<RoomEntity> adjacentRooms) {
        this.adjacentRooms = adjacentRooms;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, name = "Name")
    private String name;

    @Column(nullable = false, name = "Floor")
    private int floor;

    @OneToOne
    private SensorEntity currentTemperature;

    @Column(name = "Target_Temperature", nullable = true)
    private Double targetTemperature;

    @OneToMany(mappedBy = "room")
    private Set<WindowEntity> windowEntitySet = Set.of();

    @OneToMany(mappedBy = "roomEntity")
    private Set<HeaterEntity> heaterEntitySet = Set.of();

    @ManyToOne(optional = true)
    private BuildingEntity building;

    @ManyToMany
    @JoinTable(
            name = "SP_ADJACENT_ROOM",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "adjacent_room_id")
    )
    protected Set<RoomEntity> adjacentRooms = Set.of();

    public void addAdjacentRoom(RoomEntity adjacentRoom) {
        this.adjacentRooms.add(adjacentRoom);
    }

    public void removeAdjacentRoom(RoomEntity adjacentRoom) {
        this.adjacentRooms.remove(adjacentRoom);
    }

    public RoomEntity() {
    }

    public RoomEntity(String name, SensorEntity currentTemperature, int floor) {
        this.name = name;
        this.currentTemperature = currentTemperature;
        this.floor = floor;
    }

    public RoomEntity(long id, String name, int floor, BuildingEntity buildingEntity) {
        this.id = id;
        this.name = name;
        this.floor = floor;
        this.building= buildingEntity;
    }
}
