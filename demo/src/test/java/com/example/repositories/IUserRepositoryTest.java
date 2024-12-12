package com.example.repositories;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import com.example.models.UserModel;

@ExtendWith(MockitoExtension.class)
public class IUserRepositoryTest {

    @Mock
    private IUserRepository userRepository;

    @Test
    public void testFindById() {
        UserModel user = new UserModel();
        user.setId(1L);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<UserModel> result = userRepository.findById(1L);

        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(1L);
    }

    @Test
    public void testSave() {
        UserModel user = new UserModel();
        when(userRepository.save(user)).thenReturn(user);

        UserModel result = userRepository.save(user);

        assertThat(result).isEqualTo(user);
    }
}