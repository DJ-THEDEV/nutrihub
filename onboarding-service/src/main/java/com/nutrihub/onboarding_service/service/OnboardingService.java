package com.nutrihub.onboarding_service.service;

import com.nutrihub.onboarding_service.entity.Subscriptions;
import com.nutrihub.onboarding_service.entity.TenantDocuments;
import com.nutrihub.onboarding_service.entity.Tenants;
import com.nutrihub.onboarding_service.entity.Users;
import com.nutrihub.onboarding_service.entity.dto.*;
import com.nutrihub.onboarding_service.repository.TenantsRepo;
import com.nutrihub.onboarding_service.repository.UsersRepo;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class OnboardingService {

    private ModelMapper modelMapper;

    @Value("${tenant.documentPath}")
    private String documentPath;

    private TenantsRepo tenantsRepo;

    private UsersRepo usersRepo;

    @Transactional
    public String createTenantAccount(TenantRequestDto dto, MultipartFile[] files) {

        try {
            validateFiles(dto, files);

            Date now = new Date();

            Tenants tenant = buildTenant(dto, now);

            Subscriptions subscription = buildSubscription(dto, tenant, now);

            List<TenantDocuments> documents =
                    buildTenantDocuments(dto, files, tenant);

            tenant.setSubscriptions(subscription);
            tenant.setDocuments(documents);

            tenantsRepo.save(tenant);

            sendInviteToUser(dto.getAdminEmailId(),tenant.getId());

            return "Tenant Saved Successfully";
        }catch (Exception e){
            throw new RuntimeException("Failed to save Tenant"+e.getMessage());
        }
    }

    private void sendInviteToUser(String adminEmailId,Long tenantId) {

    }

    private Tenants buildTenant(TenantRequestDto dto, Date now) {
        return Tenants.builder()
                .name(dto.getName())
                .businessType(dto.getBusinessType())
                .status("CREATED")
                .createdAt(now)
                .build();
    }

    private Subscriptions buildSubscription(
            TenantRequestDto dto,
            Tenants tenant,
            Date now
    ) {
        int durationMonths = Integer.parseInt(dto.getSubscription().getPlan());


        Date validTill = Date.from( LocalDate.now()
                .plusMonths(Long.parseLong(dto.getSubscription().getPlan()))
                .atStartOfDay(ZoneId.systemDefault()) .toInstant() );
        return Subscriptions.builder()
                .tenant(tenant)
                .plan(dto.getSubscription().getPlan())
                .status("ACTIVE")
                .validFrom(now)
                .validTill(validTill)
                .createdAt(now)
                .build();
    }

    private List<TenantDocuments> buildTenantDocuments(
            TenantRequestDto dto,
            MultipartFile[] files,
            Tenants tenant
    ) {
        return IntStream.range(0, dto.getDocuments().size())
                .mapToObj(i -> TenantDocuments.builder()
                        .tenant(tenant)
                        .docPath(documentPath + "/" + files[i].getOriginalFilename())
                        .docType(dto.getDocuments().get(i).getDocType())
                        .build()
                )
                .collect(Collectors.toList());
    }

    private void validateFiles(TenantRequestDto dto, MultipartFile[] files) {
        if (files == null || files.length != dto.getDocuments().size()) {
            throw new IllegalArgumentException("Documents and files count mismatch");
        }
    }



    public String registerUser(UsersRequestDto usersRequestDto) {
        Tenants tenant=null;
        if (usersRequestDto.getTenantId().isEmpty()) {

            tenant = tenantsRepo.findById(Long.valueOf(usersRequestDto.getTenantId()))
                    .orElseThrow(() -> new RuntimeException("no tenant found against tenantid: " + usersRequestDto.getTenantId()));
        }

        Users user=buildUser(tenant,usersRequestDto,usersRequestDto.getRole());

        usersRepo.save(user);

        return "user saved successfully";

    }

    private Users buildUser(Tenants tenant,UsersRequestDto usersRequestDto,String role){
        return Users.builder()
                .userType(usersRequestDto.getUserType())
                .role(role)
                .email(usersRequestDto.getEmail())
                .password(usersRequestDto.getPassword())
                .tenant(tenant)
                .status("REGISTERED")
                .contactNo(usersRequestDto.getContactNo())
                .build();
    }

    public  String inviteStaff(StaffRequestDto staffRequestDto) {
        sendInviteToUser(staffRequestDto.getEmailId(),staffRequestDto.getTenantId());

        return "invitation sent successfully";

    }
}
