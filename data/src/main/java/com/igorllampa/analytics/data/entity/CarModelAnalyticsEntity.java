package com.igorllampa.analytics.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "car_model_analytics")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CarModelAnalyticsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String model;

    private Long posts;

}
