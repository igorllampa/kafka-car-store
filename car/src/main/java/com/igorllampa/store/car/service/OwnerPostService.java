package com.igorllampa.store.car.service;

import com.igorllampa.store.car.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {

    void createOwnerPost(OwnerPostDTO ownerPostDTO);
}
