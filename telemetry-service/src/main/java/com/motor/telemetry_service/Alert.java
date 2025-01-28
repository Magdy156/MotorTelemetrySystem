package com.motor.telemetry_service;

import jakarta.persistence.*;

@Entity
public class Alert {
    @Id
    @SequenceGenerator(
        name ="alert_sequence",
        sequenceName = "alert_sequence",
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alert_sequence")
    private Long id;
    private String type;
    private String message;
    private double threshold;
    private String unit;

    public Alert(){
    }

    // getters
    public Long getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public String getMessage() {
        return message;
    }
    public double getThreshold() {
        return threshold;
    }
    public String getUnit() {
        return unit;
    }

    //setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
}
