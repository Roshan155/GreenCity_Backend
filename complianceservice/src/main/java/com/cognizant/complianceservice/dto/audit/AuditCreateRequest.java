package com.cognizant.complianceservice.dto.audit;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditCreateRequest {
    @NotBlank
    @Size(max = 255)
    private String scope;


    private LocalDateTime date;

    @NotBlank
    @Size(max = 255)
    private String status;

    @NotBlank

    @Size(max = 2000)
    private String findings;

}
