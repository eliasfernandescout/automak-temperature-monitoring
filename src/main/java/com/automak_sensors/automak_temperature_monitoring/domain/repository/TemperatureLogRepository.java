package com.automak_sensors.automak_temperature_monitoring.domain.repository;

import com.automak_sensors.automak_temperature_monitoring.domain.model.TemperatureLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureLogRepository extends JpaRepository<TemperatureLog, String> {
    Page<TemperatureLog> findAllBySensorId(String sensorId, Pageable pageable);
}