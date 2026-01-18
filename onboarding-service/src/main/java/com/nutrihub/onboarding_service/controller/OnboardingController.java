package com.nutrihub.onboarding_service.controller;

import com.nutrihub.onboarding_service.entity.dto.CustomerRequestDto;
import com.nutrihub.onboarding_service.entity.dto.StaffRequestDto;
import com.nutrihub.onboarding_service.entity.dto.TenantRequestDto;
import com.nutrihub.onboarding_service.service.OnboardingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/onboarding")
@RequiredArgsConstructor
public class OnboardingController {

    private OnboardingService onboardingService;


    @PostMapping("/tenant/registration")
    public ResponseEntity<String> inviteTenant(@RequestBody TenantRequestDto tenantRequestDto){
        return ResponseEntity.ok(onboardingService.createTenantAccount(tenantRequestDto));
    }


    @PostMapping("/customer/registration")
    public ResponseEntity<String> inviteCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        return ResponseEntity.ok(onboardingService.createCustomerAccount(customerRequestDto));
    }



    @PostMapping("/staff/registration")
    public ResponseEntity<String> inviteStaff(@RequestBody StaffRequestDto staffRequestDto){
        return ResponseEntity.ok(onboardingService.createStaffAccount(staffRequestDto));
    }
}
