package com.igorllampa.store.car.service;

import com.igorllampa.store.car.dto.CarPostDTO;
import com.igorllampa.store.car.model.CarPostModel;
import com.igorllampa.store.car.repository.CarPostRepository;
import com.igorllampa.store.car.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarPostServiceImpl implements CarPostService {

    @Autowired
    private CarPostRepository carPostRepository;

    @Autowired
    private OwnerPostRepository ownerPostRepository;


    @Override
    public void newPostDetails(CarPostDTO carPostDTO) {
        CarPostModel carPostEntity = mapCarDtoToEntity(carPostDTO);
        carPostRepository.save(carPostEntity);
    }

    @Override
    public List<CarPostDTO> getCarSales() {
        List<CarPostDTO> listCarSales = new ArrayList<>();
        carPostRepository.findAll().forEach(item -> {
            listCarSales.add(mapEntityToDTO(item));
        });

        return listCarSales;
    }

    @Override
    public void changeCarSale(CarPostDTO carPostDTO, Long postId) {

        carPostRepository.findById(postId).ifPresentOrElse(item -> {
                item.setDescription(carPostDTO.getDescription());
                item.setContact(carPostDTO.getContact());
                item.setPrice(carPostDTO.getPrice());
                item.setBrand(carPostDTO.getBrand());
                item.setEngineVersion(carPostDTO.getEngineVersion());
                item.setModel(carPostDTO.getModel());

                carPostRepository.save(item);
            },
                () -> {
                throw new NoSuchElementException();
            }
            );
    }

    @Override
    public void removeCarSale(Long postId) {
        carPostRepository.deleteById(postId);
    }

    private CarPostDTO mapEntityToDTO(CarPostModel carPostModel){
        return CarPostDTO.builder()
                .brand(carPostModel.getBrand())
                .city(carPostModel.getCity())
                .model(carPostModel.getModel())
                .description(carPostModel.getDescription())
                .engineVersion(carPostModel.getEngineVersion())
                .createdDate(carPostModel.getCreatedDate())
                .ownerName(carPostModel.getOwnerPost().getName())
                .ownerType(carPostModel.getOwnerPost().getType())
                .ownerId(carPostModel.getOwnerPost().getId())
                .contact(carPostModel.getContact())
                .price(carPostModel.getPrice()).build();
    }

    private CarPostModel mapCarDtoToEntity(CarPostDTO carPostDTO) {
        CarPostModel carPostEntity = new CarPostModel();

        ownerPostRepository.findById(carPostDTO.getOwnerId()).ifPresentOrElse(item->{
            carPostEntity.setOwnerPost(item);
            carPostEntity.setContact(item.getContactNumber());
        }, ()-> {
            throw new RuntimeException();
        });

        carPostEntity.setModel(carPostDTO.getModel());
        carPostEntity.setBrand(carPostDTO.getBrand());
        carPostEntity.setPrice(carPostDTO.getPrice());
        carPostEntity.setCity(carPostDTO.getCity());
        carPostEntity.setDescription(carPostDTO.getDescription());
        carPostEntity.setEngineVersion(carPostDTO.getEngineVersion());
        carPostEntity.setCreatedDate(String.valueOf(new Date()));

        return carPostEntity;
    }

}
