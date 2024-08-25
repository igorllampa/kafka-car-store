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
        saveBrandAnalytics(carPostDTO.getBrand());
        saveCarModelAnalytics(carPostDTO.getModel());
        saveCarModelPriceAnalytics(carPostDTO.getModel(), carPostDTO.getPrice());
    }

    private void saveBrandAnalytics(String brand){
        brandAnalyticsRepository.findByBrand(brand).ifPresentOrElse(item -> {
            item.setPosts(item.getPosts()+1);
            brandAnalyticsRepository.save(item);
        }, () -> {
            var brandAnalyticsEntity = BrandAnalyticsEntity.builder()
                    .brand(brand)
                    .posts(1L)
                    .build();
            brandAnalyticsRepository.save(brandAnalyticsEntity);
        });
    }

    private void saveCarModelAnalytics(String model){
        carModelAnalyticsRepository.findByModel(model).ifPresentOrElse(item -> {
            item.setPosts(item.getPosts()+1);
            carModelAnalyticsRepository.save(item);
        }, () -> {
            var carModelAnalyticsEntity =
                    CarModelAnalyticsEntity.builder()
                    .model(model)
                    .posts(1L)
                    .build();

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
