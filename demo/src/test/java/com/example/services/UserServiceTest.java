package com.example.services;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import com.example.models.UserModel;
import com.example.repositories.IUserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private IUserRepository userRepository;

    @Test
    public void testGetUsers() {
        ArrayList<UserModel> users = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(users);

        assertThat(userService.getUsers()).isEqualTo(users);
    }

    @Test
    public void testSaveUser() {
        UserModel user = new UserModel();
        when(userRepository.save(user)).thenReturn(user);

        assertThat(userService.saveUser(user)).isEqualTo(user);
    }

    @Test
    public void testGetById() {
        Optional<UserModel> user = Optional.of(new UserModel());
        when(userRepository.findById(1L)).thenReturn(user);

        assertThat(userService.getById(1L)).isEqualTo(user);
    }

    @Test
    public void testUpdateById() {
        UserModel user = new UserModel();
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.save(user)).thenReturn(user);

        UserModel updatedUser = new UserModel();
        updatedUser.setFirstName("Updated");

        assertThat(userService.updateById(updatedUser, 1L)).isEqualTo(user);
    }

    @Test
    public void testDeleteUser() {
        doNothing().when(userRepository).deleteById(1L);

        assertThat(userService.deleteUser(1L)).isTrue();
    }
}
