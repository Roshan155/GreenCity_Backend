package com.cognizant.complianceservice.controller;
import com.cognizant.complianceservice.dto.audit.AuditResponse;
import com.cognizant.complianceservice.dto.audit.AuditCreateRequest;
import com.cognizant.complianceservice.service.AuditService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class AuditControllerTest {
    @Mock
    private AuditService auditService;
    @InjectMocks
    private AuditController auditController;
    @Test
    void testList() {
        List<AuditResponse> mockAudits = new ArrayList<>();
        when(auditService.listByCompliance(1)).thenReturn(mockAudits);
        List<AuditResponse> result = auditController.list(1);
        assertNotNull(result);
        verify(auditService).listByCompliance(1);
    }
    @Test
    void testGet() {
        AuditResponse mockAudit = AuditResponse.builder().auditId(1).status("Completed").build();
        when(auditService.getByCompliance(1, 1)).thenReturn(mockAudit);
        AuditResponse result = auditController.get(1, 1);
        assertNotNull(result);
        verify(auditService).getByCompliance(1, 1);
    }
    @Test
    void testCreate() {
        AuditCreateRequest req = AuditCreateRequest.builder().status("Pending").build();
        AuditResponse res = AuditResponse.builder().auditId(1).status("Pending").build();
        when(auditService.create(1, req)).thenReturn(res);
        AuditResponse result = auditController.create(1, req);
        assertNotNull(result);
        verify(auditService).create(1, req);
    }
    @Test
    void testDelete() {
        auditController.delete(1, 1);
        verify(auditService).delete(1, 1);
    }
}
