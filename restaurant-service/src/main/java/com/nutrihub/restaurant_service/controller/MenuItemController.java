package com.nutrihub.restaurant_service.controller;

import com.nutrihub.restaurant_service.entity.dto.MenuItemReviewRequestDto;
import com.nutrihub.restaurant_service.entity.dto.MenuItemsRequestDto;
import com.nutrihub.restaurant_service.entity.dto.MenuItemsSearchRequestDto;
import com.nutrihub.restaurant_service.entity.dto.MenuItemsSearchResponseDto;
import com.nutrihub.restaurant_service.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/search")
    public ResponseEntity<Page<MenuItemsSearchResponseDto>> searchMenuItems(
            @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "10") int size,
    @RequestParam(defaultValue = "createdAt") String sortBy,
    @RequestParam(defaultValue = "DESC") String sortDir,
    MenuItemsSearchRequestDto request) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.Direction.fromString(sortDir),
                sortBy
        );

        return ResponseEntity.ok(menuItemService.searchMenuItems(request,pageable));
    }

}
