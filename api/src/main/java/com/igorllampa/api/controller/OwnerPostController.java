package com.igorllampa.api.controller;

import com.igorllampa.api.dto.OwnerPostDTO;
import com.igorllampa.api.service.OwnerPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class OwnerPostController {

    private final Logger LOG = LoggerFactory.getLogger(OwnerPostController.class);

    @Autowired
    private OwnerPostService ownerPostService;

    @PostMapping
    public ResponseEntity createOwnerCar(@RequestBody OwnerPostDTO ownerPostDTO){

        LOG.info("MAIN REST API - Produced User Post information: {}", ownerPostDTO);

        ownerPostService.createOwnerCar(ownerPostDTO);
        return ResponseEntity.ok().build();
    }
}
