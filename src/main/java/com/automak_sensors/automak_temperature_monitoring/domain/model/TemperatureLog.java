package com.automak_sensors.automak_temperature_monitoring.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TemperatureLog {

    @Id
    private String id;
    @Column(name = "\"value\"")
    private Double value;
    private String registeredAt;
    private String sensorId;
}
