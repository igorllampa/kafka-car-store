package com.igorllampa.api.service;

import com.igorllampa.api.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {

    void createOwnerCar(OwnerPostDTO ownerPostDTO);
}
