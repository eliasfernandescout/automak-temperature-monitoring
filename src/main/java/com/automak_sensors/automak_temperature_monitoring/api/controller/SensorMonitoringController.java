package com.automak_sensors.automak_temperature_monitoring.api.controller;

import com.automak_sensors.automak_temperature_monitoring.api.model.SensorMonitoringOutput;
import com.automak_sensors.automak_temperature_monitoring.domain.repository.SensorMonitoringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/enable")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void enableSensorMonitoring(@PathVariable String sensorId) {
        sensorMonitoringRepository.findById(sensorId)
                .ifPresent(sensorMonitoring -> {
                    sensorMonitoring.setEnabled(true);
                    sensorMonitoringRepository.save(sensorMonitoring);
                });
    }


    @DeleteMapping("/disable")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void disableSensorMonitoring(@PathVariable String sensorId) {
        sensorMonitoringRepository.findById(sensorId)
                .ifPresent(sensorMonitoring -> {
                    sensorMonitoring.setEnabled(false);
                    sensorMonitoringRepository.save(sensorMonitoring);
                });
    }
}
