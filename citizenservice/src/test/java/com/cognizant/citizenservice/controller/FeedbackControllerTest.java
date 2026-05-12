package com.cognizant.citizenservice.controller;
import com.cognizant.citizenservice.dto.feedback.FeedbackResponse;
import com.cognizant.citizenservice.dto.feedback.FeedbackCreateRequest;
import com.cognizant.citizenservice.service.FeedbackService;
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
class FeedbackControllerTest {
    @Mock
    private FeedbackService feedbackService;
    @Mock
    private Authentication authentication;
    @InjectMocks
    private FeedbackController feedbackController;
    @Test
    void testListMine() {
        List<FeedbackResponse> mockFeedbacks = new ArrayList<>();
        when(feedbackService.listMine(authentication)).thenReturn(mockFeedbacks);
        List<FeedbackResponse> result = feedbackController.listMine(authentication);
        assertNotNull(result);
        verify(feedbackService).listMine(authentication);
    }
    @Test
    void testListAll() {
        List<FeedbackResponse> mockFeedbacks = new ArrayList<>();
        when(feedbackService.listAll()).thenReturn(mockFeedbacks);
        List<FeedbackResponse> result = feedbackController.listAll();
        assertNotNull(result);
        verify(feedbackService).listAll();
    }
    @Test
    void testGetMine() {
        FeedbackResponse mockFeedback = FeedbackResponse.builder().feedbackId(1).comments("Great").build();
        when(feedbackService.getMine(1, authentication)).thenReturn(mockFeedback);
        FeedbackResponse result = feedbackController.getMine(1, authentication);
        assertNotNull(result);
        verify(feedbackService).getMine(1, authentication);
    }
    @Test
    void testCreate() {
        FeedbackCreateRequest req = FeedbackCreateRequest.builder().comments("Great").build();
        FeedbackResponse res = FeedbackResponse.builder().feedbackId(1).comments("Great").build();
        when(feedbackService.create(req, authentication)).thenReturn(res);
        FeedbackResponse result = feedbackController.create(req, authentication);
        assertNotNull(result);
        verify(feedbackService).create(req, authentication);
    }
    @Test
    void testDelete() {
        feedbackController.delete(1, authentication);
        verify(feedbackService).delete(1, authentication);
    }
}
