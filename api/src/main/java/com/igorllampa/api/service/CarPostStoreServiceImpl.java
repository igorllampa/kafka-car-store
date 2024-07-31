package com.igorllampa.api.service;

import com.igorllampa.api.client.CarPostStoreClient;
import com.igorllampa.api.dto.CarPostDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarPostStoreServiceImpl implements CarPostStoreService{

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    @Override
    public List<CarPostDTO> getCarForSales() {
        return null;
    }

    @Override
    public void changeCarForSale(CarPostDTO carPostDTO, String id) {

    }

    @Override
    public void removeCarForSale(String id) {

    }
}
