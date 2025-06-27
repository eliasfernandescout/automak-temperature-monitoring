package com.automak_sensors.automak_temperature_monitoring.api.client.impl;

import com.automak_sensors.automak_temperature_monitoring.api.client.SensorMonitoringClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class SensorMonitoringClientImpl implements SensorMonitoringClient {
    private final RestClient restClient = RestClient.builder().baseUrl("http://localhost:8082").build();

    @Override
    public void enableMonitoring(String sensorId) {
        restClient.put().uri("/api/sensors/{sensorId}/monitoring/enable", sensorId)
                .retrieve().toBodilessEntity();
    }

    @Override
    public void disableMonitoring(String sensorId) {
        restClient.delete().uri("/api/sensors/{sensorId}/monitoring/disable", sensorId)
                .retrieve().toBodilessEntity();
    }
}
