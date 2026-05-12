package com.cognizant.greencity.user_service.controller;

import com.cognizant.greencity.user_service.dto.user.UserDTO;
import com.cognizant.greencity.user_service.dto.user.UserDetailsDTO;
import com.cognizant.greencity.user_service.dto.user.UserResponse;
import com.cognizant.greencity.user_service.dto.user.UserUpdateRequest;
import com.cognizant.greencity.user_service.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void testList_returnsListOfUsers() {
        // Arrange
        List<UserResponse> mockUsers = new ArrayList<>();
        mockUsers.add(UserResponse.builder().userId(1).name("user1").email("user1@example.com").build());
        mockUsers.add(UserResponse.builder().userId(2).name("user2").email("user2@example.com").build());
        when(userService.list()).thenReturn(mockUsers);

        // Act
        List<UserResponse> result = userController.list();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(userService).list();
    }

    @Test
    void testGet_returnsUserById() {
        // Arrange
        Integer userId = 1;
        UserResponse mockUser = UserResponse.builder().userId(userId).name("user1").email("user1@example.com").build();
        when(userService.get(userId)).thenReturn(mockUser);

        // Act
        UserResponse result = userController.get(userId);

        // Assert
        assertNotNull(result);
        assertEquals(userId, result.getUserId());
        verify(userService).get(userId);
    }

    @Test
    void testUpdate_updatesUserSuccessfully() {
        // Arrange
        Integer userId = 1;
        UserUpdateRequest updateRequest = UserUpdateRequest.builder().name("updatedUser").phone("1234567890").build();
        UserResponse mockUpdatedUser = UserResponse.builder().userId(userId).name("updatedUser").phone("1234567890").build();
        when(userService.update(userId, updateRequest)).thenReturn(mockUpdatedUser);

        // Act
        UserResponse result = userController.update(userId, updateRequest);

        // Assert
        assertNotNull(result);
        assertEquals("updatedUser", result.getName());
        verify(userService).update(userId, updateRequest);
    }

    @Test
    void testDelete_deletesUserSuccessfully() {
        // Arrange
        Integer userId = 1;

        // Act
        userController.delete(userId);

        // Assert
        verify(userService).delete(userId);
    }

    @Test
    void testGetUserByUsername_returnsUserDetails() {
        // Arrange
        String username = "testuser";
        UserDetailsDTO mockUserDetails = UserDetailsDTO.builder().userId(1).name(username).email("test@example.com").build();
        when(userService.findByUsername(username)).thenReturn(mockUserDetails);

        // Act
        ResponseEntity<UserDetailsDTO> result = userController.getUserByUsername(username);

        // Assert
        assertNotNull(result);
        assertEquals(200, result.getStatusCode().value());
        assertNotNull(result.getBody());
        assertEquals(username, result.getBody().getName());
        verify(userService).findByUsername(username);
    }

    @Test
    void testRegisterUser_registersNewUser() {
        // Arrange
        UserDTO userDto = UserDTO.builder().name("newuser").email("new@example.com").password("password123").build();
        UserDTO mockRegisteredUser = UserDTO.builder().name("newuser").email("new@example.com").build();
        when(userService.registerUser(userDto)).thenReturn(mockRegisteredUser);

        // Act
        UserDTO result = userController.registerUser(userDto);

        // Assert
        assertNotNull(result);
        assertEquals("newuser", result.getName());
        verify(userService).registerUser(userDto);
    }

    @Test
    void testGetById_returnUserDetailsByEmail() {
        // Arrange
        String email = "test@example.com";
        UserDetailsDTO mockUserDetails = UserDetailsDTO.builder().userId(1).name("testuser").email(email).build();
        when(userService.getById(email)).thenReturn(mockUserDetails);

        // Act
        ResponseEntity<UserDetailsDTO> result = userController.getById(email);

        // Assert
        assertNotNull(result);
        assertEquals(200, result.getStatusCode().value());
        assertNotNull(result.getBody());
        assertEquals(email, result.getBody().getEmail());
        verify(userService).getById(email);
    }
}
