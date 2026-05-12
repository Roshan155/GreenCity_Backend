package com.cognizant.citizenservice.dto.report;

import com.cognizant.citizenservice.entity.CitizenReport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitizenReportResponse {
    private Integer reportId;
    private Integer citizenId;
    private CitizenReport.ReportType type;
    private String location;
    private LocalDateTime date;
    private String status;
}
