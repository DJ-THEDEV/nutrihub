package com.nutrihub.restaurant_service.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
public class MenuItemReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menuitem_id", nullable = false)
    private MenuItems item;

    private Long userId;

    private Double rating;

    private String comments;

    private Date createdAt;
}
