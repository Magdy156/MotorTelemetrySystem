package com.motor.telemetry_service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TelemetryService {
    private final TelemetryDataRepository telemetryDataRepository;
    
    public TelemetryService(TelemetryDataRepository telemetryDataRepository) {
        this.telemetryDataRepository = telemetryDataRepository;
    }

    public TelemetryData saveTelemetryData(TelemetryData telemetryData) {
        return telemetryDataRepository.save(telemetryData);
    }

    public List<TelemetryData> getAllTelemetryData() {
        return telemetryDataRepository.findAll();
    }

    public Optional<TelemetryData> getTelemetryDataById(Long id) {
        return telemetryDataRepository.findById(id);
    }

    public void deleteTelemetryData(Long id) {
        telemetryDataRepository.deleteById(id);
    }
}
