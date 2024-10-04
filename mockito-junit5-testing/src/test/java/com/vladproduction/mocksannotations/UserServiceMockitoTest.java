package com.vladproduction.mocksannotations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceMockitoTest {
    @Mock
    UserRepository userRepositoryMock;
    @InjectMocks
    UserService userService;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetUser() {
        when(userRepositoryMock.findUserById(1)).thenReturn("John Doe");

        String user = userService.getUser(1);
        assertEquals("John Doe", user);
    }

    static class UserService{
        private UserRepository userRepository;
        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }
        public String getUser(int id){
            return userRepository.findUserById(id);
        }
    }

    interface UserRepository{
        String findUserById(int id);
    }

}
