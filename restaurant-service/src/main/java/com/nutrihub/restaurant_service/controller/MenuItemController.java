package com.nutrihub.restaurant_service.controller;

import com.nutrihub.restaurant_service.entity.dto.MenuItemReviewRequestDto;
import com.nutrihub.restaurant_service.entity.dto.MenuItemsRequestDto;
import com.nutrihub.restaurant_service.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/menu/item")
@RequiredArgsConstructor
public class MenuItemController {

    private MenuItemService menuItemService;


    @PostMapping("/addOrUpdate")
    public ResponseEntity<String> addOrUpdateMenuItem(@RequestBody MenuItemsRequestDto menuItemsRequestDto){
        return ResponseEntity.ok(menuItemService.addOrUpdateMenuItem(menuItemsRequestDto));
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteMenuItem(@RequestBody MenuItemsRequestDto menuItemsRequestDto){
        return ResponseEntity.ok(menuItemService.deleteMenuItem(menuItemsRequestDto));
    }

    @PostMapping("/rate")
    public ResponseEntity<String> rateMenuItem(@RequestBody MenuItemReviewRequestDto menuItemReviewRequestDto){
        return ResponseEntity.ok(menuItemService.rateMenuItem(menuItemReviewRequestDto));
    }
}
