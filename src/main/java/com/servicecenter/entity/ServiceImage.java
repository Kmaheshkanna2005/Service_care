package com.servicecenter.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "service_images")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl; // path or URL of image

    private String type; // BEFORE / AFTER

    @ManyToOne
    @JoinColumn(name = "complaint_id")
    private Complaint complaint;
}