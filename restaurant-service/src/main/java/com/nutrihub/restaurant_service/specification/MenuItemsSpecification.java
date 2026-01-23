package com.nutrihub.restaurant_service.specification;

import com.nutrihub.restaurant_service.entity.MenuItems;
import com.nutrihub.restaurant_service.entity.dto.MenuItemsSearchRequestDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class MenuItemsSpecification {


        public static Specification<MenuItems> buildMenuItemsSearchSpecification(MenuItemsSearchRequestDto request) {

            GenericSpecification<MenuItems> spec = new GenericSpecification<>();

            return Specification
                    .where(spec.likeIgnoreCase("name", request.getName()))
                    .and(spec.equal("itemType", request.getItemType()))
                    .and(spec.booleanEqual("isVeg", request.getIsVeg()));
        }


}
