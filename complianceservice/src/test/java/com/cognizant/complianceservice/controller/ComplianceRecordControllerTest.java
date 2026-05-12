package com.cognizant.complianceservice.controller;
import com.cognizant.complianceservice.dto.compliance.ComplianceRecordResponse;
import com.cognizant.complianceservice.dto.compliance.ComplianceRecordCreateRequest;
import com.cognizant.complianceservice.service.ComplianceRecordService;
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
class ComplianceRecordControllerTest {
    @Mock
    private ComplianceRecordService complianceRecordService;
    @InjectMocks
    private ComplianceRecordController complianceRecordController;
    @Test
    void testList() {
        List<ComplianceRecordResponse> mockRecords = new ArrayList<>();
        when(complianceRecordService.list()).thenReturn(mockRecords);
        List<ComplianceRecordResponse> result = complianceRecordController.list();
        assertNotNull(result);
        verify(complianceRecordService).list();
    }
    @Test
    void testListMine() {
        List<ComplianceRecordResponse> mockRecords = new ArrayList<>();
        when(complianceRecordService.listMine()).thenReturn(mockRecords);
        List<ComplianceRecordResponse> result = complianceRecordController.listMine();
        assertNotNull(result);
        verify(complianceRecordService).listMine();
    }
    @Test
    void testGet() {
        ComplianceRecordResponse mockRecord = ComplianceRecordResponse.builder().complianceId(1).result("Active").build();
        when(complianceRecordService.get(1)).thenReturn(mockRecord);
        ComplianceRecordResponse result = complianceRecordController.get(1);
        assertNotNull(result);
        verify(complianceRecordService).get(1);
    }
    @Test
    void testCreate() {
        ComplianceRecordCreateRequest req = ComplianceRecordCreateRequest.builder().entityId(1).entityType("Project").result("Pending").notes("Test notes").build();
        ComplianceRecordResponse res = ComplianceRecordResponse.builder().complianceId(1).entityId(1).entityType("Project").result("Pending").notes("Test notes").build();
        when(complianceRecordService.create(req)).thenReturn(res);
        ComplianceRecordResponse result = complianceRecordController.create(req);
        assertNotNull(result);
        verify(complianceRecordService).create(req);
    }
    @Test
    void testDelete() {
        complianceRecordController.delete(1);
        verify(complianceRecordService).delete(1);
    }
}
