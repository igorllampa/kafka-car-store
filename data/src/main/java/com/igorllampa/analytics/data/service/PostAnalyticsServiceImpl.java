package com.igorllampa.analytics.data.service;

import com.igorllampa.analytics.data.dto.CarPostDTO;
import com.igorllampa.analytics.data.entity.BrandAnalyticsEntity;
import com.igorllampa.analytics.data.entity.CarModelAnalyticsEntity;
import com.igorllampa.analytics.data.entity.CarModelPriceEntity;
import com.igorllampa.analytics.data.repository.BrandAnalyticsRepository;
import com.igorllampa.analytics.data.repository.CarModelAnalyticsRepository;
import com.igorllampa.analytics.data.repository.CarModelPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostAnalyticsServiceImpl implements PostAnalyticsService{

    @Autowired
    private BrandAnalyticsRepository brandAnalyticsRepository;

    @Autowired
    private CarModelAnalyticsRepository carModelAnalyticsRepository;

    @Autowired
    private CarModelPriceRepository carModelPriceRepository;


    @Override
    public void saveDataAnalytics(CarPostDTO carPostDTO) {

    }

    private void saveBrandAnalytics(String brand){
        brandAnalyticsRepository.findByBrand(brand).ifPresentOrElse(item -> {
            item.setPosts(item.getPosts()+1);
            brandAnalyticsRepository.save(item);
        }, () -> {
            BrandAnalyticsEntity brandAnalyticsEntity = new BrandAnalyticsEntity(1L, brand, 1L);
            brandAnalyticsRepository.save(brandAnalyticsEntity);
        });
    }

    private void saveCarModelAnalytics(String model){
        carModelAnalyticsRepository.findByModel(model).ifPresentOrElse(item -> {
            item.setPosts(item.getPosts()+1);
            carModelAnalyticsRepository.save(item);
        }, () -> {
            CarModelAnalyticsEntity carModelAnalyticsEntity = new CarModelAnalyticsEntity(1L, model, 1L);
            carModelAnalyticsRepository.save(carModelAnalyticsEntity);
        });
    }

    private void saveCarModelPriceAnalytics(String carModel, Double price){
        CarModelPriceEntity carModelPriceEntity = new CarModelPriceEntity();

        carModelPriceEntity.setModel(carModel);
        carModelPriceEntity.setPrice(price);

        carModelPriceRepository.save(carModelPriceEntity);
    }
}
