package com.igorllampa.store.car.repository;

import com.igorllampa.store.car.model.OwnerPostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerPostRepository extends JpaRepository<OwnerPostModel, Long> {
}
