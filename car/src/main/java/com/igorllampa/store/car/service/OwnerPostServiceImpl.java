package com.igorllampa.store.car.service;

import com.igorllampa.store.car.dto.OwnerPostDTO;
import com.igorllampa.store.car.model.OwnerPostModel;
import com.igorllampa.store.car.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService{

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void createOwnerPost(OwnerPostDTO ownerPostDTO) {

        OwnerPostModel ownerPostModel = new OwnerPostModel();
        ownerPostModel.setContactNumber(ownerPostDTO.getContactNumber());
        ownerPostModel.setName(ownerPostDTO.getName());
        ownerPostModel.setType(ownerPostDTO.getType());

        ownerPostRepository.save(ownerPostModel);
    }
}
