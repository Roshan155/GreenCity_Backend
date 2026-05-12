package com.cognizant.citizenservice.dto.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationCreateRequest {
    private Integer userId;
    private Integer projectId;
    private Integer entityId;
    private String entityType;
    private String category;
}
