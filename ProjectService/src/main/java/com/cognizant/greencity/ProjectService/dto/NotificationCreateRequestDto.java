package com.cognizant.greencity.ProjectService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationCreateRequestDto {
    private Integer userId;
    private Integer projectId;
    private Integer entityId;
    private String entityType;
    private String category;
}
