package com.vladproduction.services.springdatajpa;

import com.vladproduction.model.Speciality;
import com.vladproduction.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService specialitySDJpaService;
/**
 * Behavior Driven Development (BDD)
 *
 * */
    @Test
    public void testFindByIdBdd(){
        //given
        Speciality speciality = new Speciality();
        given(specialtyRepository.findById(1L)).willReturn(Optional.of(speciality)); //mock response for the findById method
        //when
        Speciality foundSpeciality = specialitySDJpaService.findById(1L); //describes the action that triggers the behavior of testing
        //then
        assertThat(foundSpeciality).isNotNull(); //asserts the expected outcome of the action
        verify(specialtyRepository).findById(anyLong()); //verify that the expected interaction with the mock repository occurred
    }

    @Test
    public void testDeleteByObject(){
        Speciality speciality = new Speciality();
        specialitySDJpaService.delete(speciality);
        verify(specialtyRepository).delete(any(Speciality.class));
    }

    @Test
    public void testFindById(){
        Speciality speciality = new Speciality();
        when(specialtyRepository.findById(1L)).thenReturn(Optional.of(speciality));
        Speciality foundSpecialty = specialitySDJpaService.findById(1L);
        assertThat(foundSpecialty).isNotNull();
        verify(specialtyRepository, times(1)).findById(anyLong());
        assertNotNull(foundSpecialty);
        assertEquals(speciality.getId(), foundSpecialty.getId());
    }

    @Test
    void deleteById() {
        specialitySDJpaService.deleteById(1L);
        verify(specialtyRepository).deleteById(1L);
    }

    @Test
    void deleteById_Twice() {
        specialitySDJpaService.deleteById(1L);
        specialitySDJpaService.deleteById(1L);
        verify(specialtyRepository, times(2)).deleteById(1L);
    }

    @Test
    void deleteById_atLeastOnce() {
        specialitySDJpaService.deleteById(1L);
        specialitySDJpaService.deleteById(1L);
        verify(specialtyRepository, atLeastOnce()).deleteById(1L);
    }

    @Test
    void deleteById_atMost() {
        specialitySDJpaService.deleteById(1L);
        specialitySDJpaService.deleteById(1L);
        verify(specialtyRepository, atMost(5)).deleteById(1L);
    }

    @Test
    void deleteById_never() {
        specialitySDJpaService.deleteById(1L);
        specialitySDJpaService.deleteById(1L);
        verify(specialtyRepository, atLeastOnce()).deleteById(1L);

        verify(specialtyRepository, never()).deleteById(5L);
    }
    @Test
    void delete() {
        specialitySDJpaService.delete(new Speciality());
    }
}