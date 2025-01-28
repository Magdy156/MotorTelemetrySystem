package com.motor.telemetry_service;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class TelemetryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelemetryServiceApplication.class, args);
	}

	@Bean
    CommandLineRunner runner(TelemetryRepository repository) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("telemetry_data_10_items_no_location.json");
            try {
                List<TelemetryData> telemetryDataList = mapper.readValue(file, new TypeReference<>() {});
                if (repository.count() == 0) {
                    repository.saveAll(telemetryDataList);
                    System.out.println("Data migration completed successfully.");
                } else {
                    System.out.println("Data already exists. Migration skipped.");
                }
            } catch (IOException e) {
                System.err.println("Failed to read or parse the JSON file: " + e.getMessage());
            }
        };
    }
}
