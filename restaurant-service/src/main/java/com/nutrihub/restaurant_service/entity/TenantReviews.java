package com.nutrihub.restaurant_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.xml.transform.sax.SAXResult;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
public class TenantReviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tenantId;

    private Long userId;

    private Double rating;

    private String comments;

    private Date createdAt;

}
