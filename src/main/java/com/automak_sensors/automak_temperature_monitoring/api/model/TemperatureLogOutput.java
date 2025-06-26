package com.automak_sensors.automak_temperature_monitoring.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TemperatureLogOutput {
    private String id;
    private Double value;
    private String registeredAt;
    private String sensorId;
}

