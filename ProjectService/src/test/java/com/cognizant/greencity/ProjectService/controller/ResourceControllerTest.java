package com.cognizant.greencity.ProjectService.controller;
import com.cognizant.greencity.ProjectService.dto.ResourceResponseDto;
import com.cognizant.greencity.ProjectService.dto.ResourceCreateRequestDto;
import com.cognizant.greencity.ProjectService.service.ResourceService;
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
class ResourceControllerTest {
    @Mock
    private ResourceService resourceService;
    @InjectMocks
    private ResourceController resourceController;
    @Test
    void testListResources() {
        List<ResourceResponseDto> mockResources = new ArrayList<>();
        when(resourceService.listResources(null)).thenReturn(mockResources);
        List<ResourceResponseDto> result = resourceController.listResources(null);
        assertNotNull(result);
        verify(resourceService).listResources(null);
    }
    @Test
    void testGetResource() {
        ResourceResponseDto mockResource = ResourceResponseDto.builder().resourceId(1L).type("Solar Panel").build();
        when(resourceService.getResource(1L)).thenReturn(mockResource);
        ResourceResponseDto result = resourceController.getResource(1L);
        assertNotNull(result);
        verify(resourceService).getResource(1L);
    }
    @Test
    void testResourceExists() {
        when(resourceService.resourceExists(1L)).thenReturn(true);
        Boolean result = resourceController.resourceExists(1L);
        assertTrue(result);
        verify(resourceService).resourceExists(1L);
    }
    @Test
    void testCreateResource() {
        ResourceCreateRequestDto req = ResourceCreateRequestDto.builder().projectId(1L).type("Solar Panel").location("Rooftop").capacity(100.0).build();
        ResourceResponseDto res = ResourceResponseDto.builder().resourceId(1L).projectId(1L).type("Solar Panel").location("Rooftop").capacity(100.0).status("Active").build();
        when(resourceService.createResource(req)).thenReturn(res);
        ResourceResponseDto result = resourceController.createResource(req);
        assertNotNull(result);
        verify(resourceService).createResource(req);
    }
    @Test
    void testDeleteResource() {
        resourceController.deleteResource(1L);
        verify(resourceService).deleteResource(1L);
    }
}