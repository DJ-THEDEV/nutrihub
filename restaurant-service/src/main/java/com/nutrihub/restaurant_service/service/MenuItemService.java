package com.nutrihub.restaurant_service.service;

import com.nutrihub.restaurant_service.entity.MenuItemReview;
import com.nutrihub.restaurant_service.entity.MenuItems;
import com.nutrihub.restaurant_service.entity.dto.MenuItemReviewRequestDto;
import com.nutrihub.restaurant_service.entity.dto.MenuItemsRequestDto;
import com.nutrihub.restaurant_service.repo.MenuItemReviewRepo;
import com.nutrihub.restaurant_service.repo.MenuItemsRepo;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuItemService {

    private MenuItemsRepo menuItemsRepo;

    private MenuItemReviewRepo menuItemReviewRepo;

    private ModelMapper modelMapper;

    public  String addOrUpdateMenuItem(MenuItemsRequestDto menuItemsRequestDto) {
        List<MenuItemReview> menuItemReview = null;
        if (menuItemsRequestDto.getId()!=null){
           MenuItems menuItems= menuItemsRepo.findById(menuItemsRequestDto.getId())
                    .orElseThrow(() -> new RuntimeException("no menuitem found against menuItemid: " + menuItemsRequestDto.getId()));

           menuItemReview=menuItems.getMenuItemReviews();

        }
        MenuItems menuItem=modelMapper.map(menuItemsRequestDto,MenuItems.class);

        menuItem.setMenuItemReviews(menuItemReview);

        menuItemsRepo.save(menuItem);

        return "saved successfully";


    }

    public  String deleteMenuItem(MenuItemsRequestDto menuItemsRequestDto) {

        menuItemsRepo.deleteById(menuItemsRequestDto.getId());

        return "deleted successfully ";

    }

    public  String rateMenuItem(MenuItemReviewRequestDto menuItemReviewRequestDto) {
        MenuItemReview menuItemReview=modelMapper.map(menuItemReviewRequestDto,MenuItemReview.class);

        MenuItems menuItems= menuItemsRepo.findById(menuItemReviewRequestDto.getMenuItemId())
                .orElseThrow(() -> new RuntimeException("no menuitem found against menuItemid: " + menuItemReviewRequestDto.getMenuItemId()));

        menuItemReview.setItem(menuItems);

        menuItemReviewRepo.save(menuItemReview);

        return "saved successfully";

    }
}
