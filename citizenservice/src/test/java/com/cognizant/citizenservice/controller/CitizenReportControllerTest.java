package com.cognizant.citizenservice.controller;
import com.cognizant.citizenservice.dto.report.CitizenReportResponse;
import com.cognizant.citizenservice.dto.report.CitizenReportCreateRequest;
import com.cognizant.citizenservice.service.CitizenReportService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class CitizenReportControllerTest {
    @Mock
    private CitizenReportService citizenReportService;
    @Mock
    private Authentication authentication;
    @InjectMocks
    private CitizenReportController citizenReportController;
    @Test
    void testListMine() {
        List<CitizenReportResponse> mockReports = new ArrayList<>();
        when(citizenReportService.listMine(authentication)).thenReturn(mockReports);
        List<CitizenReportResponse> result = citizenReportController.listMine(authentication);
        assertNotNull(result);
        verify(citizenReportService).listMine(authentication);
    }
    @Test
    void testListAll() {
        List<CitizenReportResponse> mockReports = new ArrayList<>();
        when(citizenReportService.listAll()).thenReturn(mockReports);
        List<CitizenReportResponse> result = citizenReportController.listAll();
        assertNotNull(result);
        verify(citizenReportService).listAll();
    }
    @Test
    void testGetMine() {
        CitizenReportResponse mockReport = CitizenReportResponse.builder().reportId(1).location("Location").build();
        when(citizenReportService.getMine(1, authentication)).thenReturn(mockReport);
        CitizenReportResponse result = citizenReportController.getMine(1, authentication);
        assertNotNull(result);
        verify(citizenReportService).getMine(1, authentication);
    }
    @Test
    void testCreate() {
        CitizenReportCreateRequest req = CitizenReportCreateRequest.builder().location("New Location").build();
        CitizenReportResponse res = CitizenReportResponse.builder().reportId(1).location("New Location").build();
        when(citizenReportService.create(req, authentication)).thenReturn(res);
        CitizenReportResponse result = citizenReportController.create(req, authentication);
        assertNotNull(result);
        verify(citizenReportService).create(req, authentication);
    }
    @Test
    void testDelete() {
        citizenReportController.delete(1, authentication);
        verify(citizenReportService).delete(1, authentication);
    }
}
