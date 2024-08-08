package com.igorllampa.store.car.controller;

import com.igorllampa.store.car.dto.CarPostDTO;
import com.igorllampa.store.car.service.CarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class CarPostController {

    @Autowired
    private CarPostService carPostService;

    @GetMapping("/cars")
    public ResponseEntity<List<CarPostDTO>> getCarSales(){
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostService.getCarSales());
    }

    @PutMapping("/car/{id}")
    public ResponseEntity changeCarSale(@RequestBody CarPostDTO carPostDTO, @PathVariable Long id){
        carPostService.changeCarSale(carPostDTO, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity deleteCarSale(@PathVariable Long id){
        carPostService.removeCarSale(id);
        return ResponseEntity.ok().build();
    }
}
