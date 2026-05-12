package com.cognizant.greencity.ProjectService.controller;
import com.cognizant.greencity.ProjectService.dto.ProjectRequestDto;
import com.cognizant.greencity.ProjectService.dto.ProjectResponseDto;
import com.cognizant.greencity.ProjectService.service.ProjectService;
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
class ProjectControllerTest {
    @Mock
    private ProjectService projectService;
    @InjectMocks
    private ProjectController projectController;
    @Test
    void testListProjects() {
        List<ProjectResponseDto> mockProjects = new ArrayList<>();
        when(projectService.getAllProjects()).thenReturn(mockProjects);
        List<ProjectResponseDto> result = projectController.listProjects();
        assertNotNull(result);
        verify(projectService).getAllProjects();
    }
    @Test
    void testGetProject() {
        ProjectResponseDto mockProject = ProjectResponseDto.builder().projectId(1L).title("Test").build();
        when(projectService.getProject(1L)).thenReturn(mockProject);
        ProjectResponseDto result = projectController.getProject(1L);
        assertNotNull(result);
        verify(projectService).getProject(1L);
    }
    @Test
    void testCreateProject() {
        ProjectRequestDto req = ProjectRequestDto.builder().title("New").build();
        ProjectResponseDto res = ProjectResponseDto.builder().projectId(1L).title("New").build();
        when(projectService.createProject(req)).thenReturn(res);
        ProjectResponseDto result = projectController.createProject(req);
        assertNotNull(result);
        verify(projectService).createProject(req);
    }
    @Test
    void testUpdateProject() {
        ProjectRequestDto req = ProjectRequestDto.builder().title("Updated").build();
        ProjectResponseDto res = ProjectResponseDto.builder().projectId(1L).title("Updated").build();
        when(projectService.updateProject(1L, req)).thenReturn(res);
        ProjectResponseDto result = projectController.updateProject(1L, req);
        assertNotNull(result);
        verify(projectService).updateProject(1L, req);
    }
    @Test
    void testDeleteProject() {
        projectController.deleteProject(1L);
        verify(projectService).deleteProject(1L);
    }
    @Test
    void testProjectExists() {
        when(projectService.projectExists(1L)).thenReturn(true);
        Boolean result = projectController.projectExists(1L);
        assertTrue(result);
        verify(projectService).projectExists(1L);
    }
}
