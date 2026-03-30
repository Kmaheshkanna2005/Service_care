package com.servicecenter.service;

import com.servicecenter.entity.ServiceImage;
import com.servicecenter.repository.ServiceImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImageService {

    @Autowired
    private ServiceImageRepository serviceImageRepository;

    public ServiceImage saveImage(ServiceImage image) {
        return serviceImageRepository.save(image);
    }
}