package com.servicecenter.controller;

import com.servicecenter.entity.ServiceImage;
import com.servicecenter.service.ServiceImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/images")
public class ServiceImageController {

    @Autowired
    private ServiceImageService serviceImageService;

    @PostMapping
    public ServiceImage uploadImage(@RequestBody ServiceImage image) {
        return serviceImageService.saveImage(image);
    }
}