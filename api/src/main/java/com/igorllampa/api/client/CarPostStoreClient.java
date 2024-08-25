package com.igorllampa.api.client;

import com.igorllampa.api.dto.CarPostDTO;
import com.igorllampa.api.dto.OwnerPostDTO;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CarPostStoreClient {

    private final String USER_STORE_SERVICE_URI = "http://localhost:8080/user";
    private final String POSTS_STORE_SERVICE_URI = "http://localhost:8080/sales";

    @Autowired
    private RestTemplate restTemplate;

    public List<CarPostDTO> carForSaleClient(){
        ResponseEntity<CarPostDTO[]> carPostDTOList = restTemplate.getForEntity(POSTS_STORE_SERVICE_URI + "/cars", CarPostDTO[].class);
        return Arrays.asList(Objects.requireNonNull(carPostDTOList.getBody()));
    }

    public void ownerPostsClient(OwnerPostDTO newUser){
        restTemplate.postForEntity(USER_STORE_SERVICE_URI, newUser, OwnerPostDTO.class);
    }

    public void changeCarForSaleClient(CarPostDTO carPostDTO, String id){
        restTemplate.put(POSTS_STORE_SERVICE_URI+"/car/"+id, carPostDTO, CarPostDTO.class);
    }

    public void deleteCarForSaleClient(String id){
        restTemplate.delete(POSTS_STORE_SERVICE_URI+"/car/"+id);
    }
}
