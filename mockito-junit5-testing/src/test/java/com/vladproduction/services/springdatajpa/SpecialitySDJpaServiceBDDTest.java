package com.vladproduction.services.springdatajpa;

import com.vladproduction.model.Speciality;
import com.vladproduction.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

/**
 * Behavior Driven Development (BDD)
 */
@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceBDDTest {

    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService specialitySDJpaService;

    @Test
    public void testFindAll(){
        // given
        Speciality speciality1 = new Speciality();
        speciality1.setId(1L);
        Speciality speciality2 = new Speciality();
        speciality2.setId(2L);

        Set<Speciality> specialitySet = new HashSet<>();
        specialitySet.add(speciality1);
        specialitySet.add(speciality2);

        given(specialtyRepository.findAll()).willReturn(specialitySet); // Mock the repository behavior

        // when
        Set<Speciality> foundSpecialities = specialitySDJpaService.findAll();

        // then
        assertThat(foundSpecialities).hasSize(2); // Check the size of the returned set
        assertThat(foundSpecialities).contains(speciality1, speciality2); // Verify the expected specialities are present
        then(specialtyRepository).should(timeout(100)).findAll(); // Verify that the repository's findAll method was called
    }

    @Test
    public void testFindById() {
        //given
        Speciality speciality = new Speciality();
        given(specialtyRepository.findById(1L)).willReturn(Optional.of(speciality));
        //when
        Speciality foundSpeciality = specialitySDJpaService.findById(1L);
        //then
        assertThat(foundSpeciality).isNotNull();
        then(specialtyRepository).should(timeout(100)).findById(anyLong());
        then(specialtyRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    public void testSave(){
        // given
        Speciality specialityToSave = new Speciality();
        given(specialtyRepository.save(specialityToSave)).willReturn(specialityToSave); // Mock repository save method

        // when
        Speciality savedSpeciality = specialitySDJpaService.save(specialityToSave);

        // then
        assertThat(savedSpeciality).isNotNull();
        assertThat(savedSpeciality).isEqualTo(specialityToSave); // Verify the saved object
        then(specialtyRepository).should(timeout(100)).save(any(Speciality.class)); // Verify the save was called
    }

    @Test
    public void testDelete() {
        //given
        Speciality speciality = new Speciality();
        //when
        specialitySDJpaService.delete(speciality);
        //then
        then(specialtyRepository).should().delete(any(Speciality.class));
    }

    @Test
    void testDeleteById() {
        //given

        //when
        specialitySDJpaService.deleteById(1L);
        //then
        then(specialtyRepository).should().deleteById(anyLong());
    }

}