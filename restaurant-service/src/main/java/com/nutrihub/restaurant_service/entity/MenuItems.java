package com.nutrihub.restaurant_service.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
public class MenuItems {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tenantId;

    private String name;

    private String description;

    private String itemType;

    private Boolean is_veg;

    private Double price;

    private Double rating;

   private Boolean isAvailable;

   @OneToMany(mappedBy = "item",cascade = CascadeType.ALL ,orphanRemoval = true)
   private List<MenuItemReview> menuItemReviews;
}
