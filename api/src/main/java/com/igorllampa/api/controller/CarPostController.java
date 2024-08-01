package com.igorllampa.api.controller;

import com.igorllampa.api.dto.CarPostDTO;
import com.igorllampa.api.message.KafkaProducerMessage;
import com.igorllampa.api.service.CarPostStoreService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarPostController {

    @Autowired
    private CarPostStoreService carPostStoreService;

    @Autowired
    private KafkaProducerMessage kafkaProducerMessage;

    @PostMapping("/posts")
    public ResponseEntity postCarForSale(@RequestBody CarPostDTO carPostDTO){
        kafkaProducerMessage.sendMessage(carPostDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDTO>> getCarSales(){
        List<CarPostDTO> carForSales = carPostStoreService.getCarForSales();
        return ResponseEntity.status(HttpStatus.FOUND).body(carForSales);
    }

    @PutMapping("/{id}")
    public ResponseEntity changeCarSale(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") String id){
        carPostStoreService.changeCarForSale(carPostDTO, id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarForSale(@PathVariable("id") String id){
        carPostStoreService.removeCarForSale(id);
        return ResponseEntity.ok().build();
    }
}
