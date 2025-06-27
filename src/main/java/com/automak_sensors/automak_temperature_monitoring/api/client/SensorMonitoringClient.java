package com.automak_sensors.automak_temperature_monitoring.api.client;

public interface SensorMonitoringClient {
    void enableMonitoring(String sensorId);
    void disableMonitoring(String sensorId);

}
