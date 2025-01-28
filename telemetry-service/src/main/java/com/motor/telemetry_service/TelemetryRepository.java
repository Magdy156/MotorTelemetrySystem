package com.motor.telemetry_service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TelemetryRepository extends JpaRepository<TelemetryData, Long> {
    
}
