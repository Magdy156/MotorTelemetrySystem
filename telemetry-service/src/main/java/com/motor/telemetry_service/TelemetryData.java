package com.motor.telemetry_service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class TelemetryData {
    @Id
    @SequenceGenerator(
        name ="telemetry_sequence",
        sequenceName = "telemetry_sequence",
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "telemetry_sequence")
    private Long id;

    @JsonProperty("device_id")
    private String deviceId;
    @JsonProperty("timestamp")
    private String timeStamp;


    @OneToOne(cascade = CascadeType.ALL)
    private Sensors sensors;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Alert> alerts;

    public TelemetryData(){
    }
    //getters
    public Long getId() {
        return id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public Sensors getSensors() {
        return sensors;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    // setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setSensors(Sensors sensors) {
        this.sensors = sensors;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }
}
