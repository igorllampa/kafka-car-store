package com.igorllampa.store.car.repository;

import com.igorllampa.store.car.model.CarPostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPostRepository extends JpaRepository<CarPostModel, Long> {
}
