package com.motor.telemetry_service;

import jakarta.persistence.*;

@Entity
public class Sensors {
    @Id
    @SequenceGenerator(
        name ="sensors_sequence",
        sequenceName = "sensors_sequence",
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sensors_sequence")
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Sensor temperature;

    @OneToOne(cascade = CascadeType.ALL)
    private Sensor battery;

    @OneToOne(cascade = CascadeType.ALL)
    private Sensor speed;

    @OneToOne(cascade = CascadeType.ALL)
    private Motor motor;
    public Sensors(){}

    //getters
    public Long getId() {
        return id;
    }

    public Sensor getTemperature() {
        return temperature;
    }

    public Sensor getBattery() {
        return battery;
    }

    public Sensor getSpeed() {
        return speed;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTemperature(Sensor temperature) {
        this.temperature = temperature;
    }

    public void setBattery(Sensor battery) {
        this.battery = battery;
    }

    public void setSpeed(Sensor speed) {
        this.speed = speed;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    // setters
    
}
