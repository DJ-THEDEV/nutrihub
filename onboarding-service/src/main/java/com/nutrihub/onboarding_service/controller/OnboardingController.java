package com.nutrihub.onboarding_service.controller;

import com.nutrihub.onboarding_service.entity.dto.CustomerRequestDto;
import com.nutrihub.onboarding_service.entity.dto.StaffRequestDto;
import com.nutrihub.onboarding_service.entity.dto.TenantRequestDto;
import com.nutrihub.onboarding_service.entity.dto.UsersRequestDto;
import com.nutrihub.onboarding_service.service.OnboardingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/onboarding")
@RequiredArgsConstructor
public class OnboardingController {

    private OnboardingService onboardingService;


    @PostMapping("/tenant/onboarding")
    public ResponseEntity<String> inviteTenant(@RequestBody TenantRequestDto tenantRequestDto, MultipartFile[] files){
        return ResponseEntity.ok(onboardingService.createTenantAccount(tenantRequestDto,files));
    }


    @PostMapping("/user/registration")
    public ResponseEntity<String> registerUser(@RequestBody UsersRequestDto usersRequestDto){
        return ResponseEntity.ok(onboardingService.registerUser(usersRequestDto));
    }

    @PostMapping("/staff/invite")
    public ResponseEntity<String> inviteStaff(@RequestBody StaffRequestDto staffRequestDto){
        return ResponseEntity.ok(onboardingService.inviteStaff(staffRequestDto));

    }


}
