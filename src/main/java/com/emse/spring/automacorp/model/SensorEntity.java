package com.emse.spring.automacorp.model;
import jakarta.persistence.*;

@Entity // (1).
@Table(name = "SP_SENSOR") // (2).
public class SensorEntity {

    public enum SensorType { TEMPERATURE, POWER, STATUS }

    @Id // (3).
    @GeneratedValue
    private Long id;

    @Column(nullable=false, length=255)  // (4).
    private String name;

    @Column(name = "sensor_value") // (5)
    private Double value;

    @Column(name = "sensor_type") // (5).
    @Enumerated(EnumType.STRING) // (6).
    private SensorType sensorType;

    @Transient // (7).
    private Integer notImportant;

    public SensorEntity() { // (8).
    }

    public SensorEntity(SensorType sensorType, String name) { // (9).
        this.name = name;
        this.sensorType = sensorType;
        if (sensorType == SensorType.STATUS) {
            this.setValue(0.0);
        } else if (sensorType == SensorType.TEMPERATURE) {
            this.setValue(20.0);
        }
    }

    public SensorEntity(Long id, String name, Double value, SensorType sensorType) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.sensorType = sensorType;
    }

    public Long getId() { // (10).
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }

}

