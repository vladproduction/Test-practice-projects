package com.vladproduction.lambdaargumentmatchers;

import com.vladproduction.model.Speciality;
import com.vladproduction.repositories.SpecialtyRepository;
import com.vladproduction.services.springdatajpa.SpecialitySDJpaService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LambdaArgumentMatchers {

    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService specialitySDJpaService;

    @Test
    public void testSaveLambda(){
        // given
        final String MATCH_ME = "MATCH_ME";
        Speciality speciality = new Speciality();
        speciality.setDescription(MATCH_ME);

        Speciality savedSpecialty = new Speciality();
        savedSpecialty.setId(1L);  // Mocking the saved object ID.

        // Mock behavior for only matching descriptions
        given(specialtyRepository.save(argThat(arg -> arg.getDescription().equals(MATCH_ME)))).willReturn(savedSpecialty);

        // when
        Speciality returnedSpecialty = specialitySDJpaService.save(speciality);

        // then
        assertThat(returnedSpecialty).isNotNull(); // Check object not null
        assertThat(returnedSpecialty.getId()).isEqualTo(1L); // Validate ID check

        //need to think about case if not matching
    }

}
