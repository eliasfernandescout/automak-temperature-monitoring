package com.automak_sensors.automak_temperature_monitoring.domain.repository;

import com.automak_sensors.automak_temperature_monitoring.domain.model.SensorMonitoring;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorMonitoringRepository extends JpaRepository<SensorMonitoring, String> {
}
