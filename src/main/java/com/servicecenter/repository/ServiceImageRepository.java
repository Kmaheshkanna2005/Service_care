package com.servicecenter.repository;

import com.servicecenter.entity.ServiceImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceImageRepository extends JpaRepository<ServiceImage, Long> {
}