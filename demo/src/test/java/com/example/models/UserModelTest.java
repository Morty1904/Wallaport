package com.example.models;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserModelTest {

    @Test
    public void testUserModelGettersAndSetters() {
        UserModel user = new UserModel();

        user.setId(1L);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");

        assertThat(user.getId()).isEqualTo(1L);
        assertThat(user.getFirstName()).isEqualTo("John");
        assertThat(user.getLastName()).isEqualTo("Doe");
        assertThat(user.getEmail()).isEqualTo("john.doe@example.com");
    }
}