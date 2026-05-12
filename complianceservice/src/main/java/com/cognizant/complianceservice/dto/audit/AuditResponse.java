package com.cognizant.complianceservice.dto.audit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditResponse {
    private Integer auditId;
    private Integer complianceId;
    private Integer officerId;
    private String scope;
    private String findings;
    private LocalDateTime date;
    private String status;
}
