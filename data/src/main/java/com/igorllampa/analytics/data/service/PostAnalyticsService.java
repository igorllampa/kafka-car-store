package com.igorllampa.analytics.data.service;

import com.igorllampa.analytics.data.dto.CarPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface PostAnalyticsService {

    void saveDataAnalytics(CarPostDTO carPostDTO);
}
