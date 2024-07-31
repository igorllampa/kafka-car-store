package com.igorllampa.api.service;

import com.igorllampa.api.client.CarPostStoreClient;
import com.igorllampa.api.dto.CarPostDTO;
import com.igorllampa.api.dto.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    @Override
    public void createOwnerCar(OwnerPostDTO ownerPostDTO) {
        carPostStoreClient.ownerPostsClient(ownerPostDTO);
    }
}

