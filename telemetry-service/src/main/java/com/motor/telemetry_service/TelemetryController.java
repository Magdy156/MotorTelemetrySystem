package com.motor.telemetry_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/telemetry")
public class TelemetryController {
    @Autowired
    private TelemetryService telemetryService;

    @PostMapping("/send")
    public ResponseEntity<TelemetryData> receiveTelemetry(@RequestBody TelemetryData telemetryData) {
        return ResponseEntity.ok(telemetryService.saveTelemetryData(telemetryData));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelemetryData> getTelemetryById(@PathVariable Long id) {
        return telemetryService.getTelemetryDataById(id)
        .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<TelemetryData>> getAllTelemetry() {
        return ResponseEntity.ok(telemetryService.getAllTelemetryData());
    }

}
