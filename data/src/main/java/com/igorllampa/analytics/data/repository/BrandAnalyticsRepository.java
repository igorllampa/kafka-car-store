package com.igorllampa.analytics.data.repository;

import com.igorllampa.analytics.data.entity.BrandAnalyticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandAnalyticsRepository extends JpaRepository<BrandAnalyticsEntity, Long> {

    Optional<BrandAnalyticsEntity> findByBrand(String brand);

}
