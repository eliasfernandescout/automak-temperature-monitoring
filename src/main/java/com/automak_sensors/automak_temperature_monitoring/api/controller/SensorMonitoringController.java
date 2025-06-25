package com.automak_sensors.automak_temperature_monitoring.api.controller;

import com.automak_sensors.automak_temperature_monitoring.api.model.SensorMonitoringOutput;
import com.automak_sensors.automak_temperature_monitoring.domain.repository.SensorMonitoringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sensors/{sensorId}/monitoring")
@RequiredArgsConstructor
public class SensorMonitoringController {

    private final SensorMonitoringRepository sensorMonitoringRepository;

    @GetMapping
    public SensorMonitoringOutput getDetail(@PathVariable String sensorId) {
        return sensorMonitoringRepository.findById(sensorId)
                .map(sensorMonitoring -> SensorMonitoringOutput.builder()
                        .id(sensorMonitoring.getId())
                        .lastTemperature(sensorMonitoring.getLastTemperature())
                        .updatedAt(sensorMonitoring.getUpdatedAt())
                        .enabled(sensorMonitoring.getEnabled())
                        .build())
                .orElseThrow(() -> new RuntimeException("Sensor monitoring not found for id: " + sensorId));
    }

}
