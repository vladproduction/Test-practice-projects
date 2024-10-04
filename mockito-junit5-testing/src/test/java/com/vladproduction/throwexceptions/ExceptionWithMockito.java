package com.vladproduction.throwexceptions;

import com.vladproduction.model.Speciality;
import com.vladproduction.repositories.SpecialtyRepository;
import com.vladproduction.services.springdatajpa.SpecialitySDJpaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ExceptionWithMockito {

    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService specialitySDJpaService;

    @Test
    public void test_DoThrow(){
        doThrow(new RuntimeException("exception is flagged")).when(specialtyRepository).delete(any());
        assertThrows(RuntimeException.class, ()-> specialtyRepository.delete(new Speciality()));
        verify(specialtyRepository).delete(any());
    }


    @Test
    public void testFindById_BDD_willThrow(){
        //given
        given(specialtyRepository.findById(1L)).willThrow(new RuntimeException("exception is flagged"));
        //when
        assertThrows(RuntimeException.class, ()-> specialitySDJpaService.findById(1L));
        //then
        then(specialtyRepository).should().findById(1L);
    }

    @Test
    public void testDeleteBDD_willThrow(){
        //given
        willThrow(new RuntimeException("exception is flagged")).given(specialtyRepository).delete(any());
        //when
        assertThrows(RuntimeException.class, ()-> specialtyRepository.delete(new Speciality()));
        //then
        then(specialtyRepository).should().delete(any());
    }

}
