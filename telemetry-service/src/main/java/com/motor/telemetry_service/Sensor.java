package com.motor.telemetry_service;


import jakarta.persistence.*;

@Entity
public class Sensor {
    @Id
    @SequenceGenerator(
        name ="sensor_sequence",
        sequenceName = "sensor_sequence",
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sensor_sequence")
    private Long id;

    private Double value;

    private String unit;
    public Sensor(){}

    //getters
    public Long getId() {
        return id;
    }
    public double getValue() {
        return value;
    }
    public String getUnit() {
        return unit;
    }
    // setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
}
