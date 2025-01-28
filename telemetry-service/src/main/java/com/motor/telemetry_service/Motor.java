package com.motor.telemetry_service;

import jakarta.persistence.*;

@Entity
public class Motor {

    @Id
    @SequenceGenerator(
        name ="motor_sequence",
        sequenceName = "motor_sequence",
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "motor_sequence")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Sensor current;

    @OneToOne(cascade = CascadeType.ALL)
    private Sensor voltage;

    @OneToOne(cascade = CascadeType.ALL)
    private Sensor power;

    public Motor(){
    }
    public Long getId() {
        return id;
    }

    public Sensor getCurrent() {
        return current;
    }

    public Sensor getVoltage() {
        return voltage;
    }

    public Sensor getPower() {
        return power;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCurrent(Sensor current) {
        this.current = current;
    }

    public void setVoltage(Sensor voltage) {
        this.voltage = voltage;
    }

    public void setPower(Sensor power) {
        this.power = power;
    }
}
