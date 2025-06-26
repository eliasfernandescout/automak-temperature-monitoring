package com.automak_sensors.automak_temperature_monitoring.api.controller;

import com.automak_sensors.automak_temperature_monitoring.api.model.TemperatureLogOutput;
import com.automak_sensors.automak_temperature_monitoring.domain.model.TemperatureLog;
import com.automak_sensors.automak_temperature_monitoring.domain.repository.TemperatureLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sendors/{sensorId}/temperature")
@RequiredArgsConstructor
public class TemperatureLogController {

    private final TemperatureLogRepository temperatureLogRepository;

    @GetMapping
    public Page<TemperatureLogOutput> search(@PathVariable String sensorId, @PageableDefault Pageable pageable) {
        Page<TemperatureLog> temperatureLogs = temperatureLogRepository.findAllBySensorId(sensorId, pageable);

        return temperatureLogs.map(temperatureLog -> TemperatureLogOutput.builder()
                .id(temperatureLog.getId())
                .value(temperatureLog.getValue())
                .registeredAt(temperatureLog.getRegisteredAt())
                .sensorId(temperatureLog.getSensorId())
                .build());
    }
}
