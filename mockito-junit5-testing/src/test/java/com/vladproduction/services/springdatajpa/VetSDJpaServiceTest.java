package com.vladproduction.services.springdatajpa;

import com.vladproduction.repositories.VetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {

    @Mock
    VetRepository vetRepository; //object we want to mock for
    @InjectMocks
    VetSDJpaService vetSDJpaService;

    @Test
    void deleteById() {
        vetSDJpaService.deleteById(1L);
        verify(vetRepository, times(1)).deleteById(1L);
    }
}