package com.vladproduction.controllers;

import com.vladproduction.model.Pet;
import com.vladproduction.model.Visit;
import com.vladproduction.services.PetService;
import com.vladproduction.services.VisitService;
import com.vladproduction.services.map.PetMapService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class VisitControllerSpyTest {
    @Mock
    VisitService visitService;
    @Spy
    PetMapService petService;
    @InjectMocks
    VisitController visitController;

    @Test
    public void loadPetWithVisit() {
        //given
        Map<String, Object> model = new HashMap<>();

        Pet pet1 = new Pet();
        pet1.setId(1L);
        petService.save(pet1);

        Pet pet2 = new Pet();
        pet2.setId(2L);
        petService.save(pet2);

        given(petService.findById(anyLong())).willCallRealMethod();

        //when
        Visit visit1 = visitController.loadPetWithVisit(1L, model);
        Visit visit2 = visitController.loadPetWithVisit(2L, model);

        //then
        assertThat(visit1).isNotNull();
        assertThat(visit1.getPet()).isNotNull();
        assertThat(visit1.getPet().getId()).isEqualTo(1L);

        assertThat(visit2).isNotNull();
        assertThat(visit2.getPet()).isNotNull();
        assertThat(visit2.getPet().getId()).isEqualTo(2L);

        verify(petService, times(2)).findById(anyLong());
    }

    @Test
    public void loadPetWithVisitWithStubbing() {
        //given
        Map<String, Object> model = new HashMap<>();

        Pet pet1 = new Pet();
        pet1.setId(1L);
        petService.save(pet1);

        Pet pet2 = new Pet();
        pet2.setId(22L);
        petService.save(pet2);

        given(petService.findById(anyLong())).willReturn(pet2);

        //when
        Visit visit2 = visitController.loadPetWithVisit(22L, model);

        //then
        assertThat(visit2).isNotNull();
        assertThat(visit2.getPet()).isNotNull();
        assertThat(visit2.getPet().getId()).isEqualTo(22L); //expected is 22L

        verify(petService, times(1)).findById(anyLong());
    }

    @Test
    public void loadPetWithVisitWithStubbing2() {
        //given
        Map<String, Object> model = new HashMap<>();

        Pet pet = new Pet();
        pet.setId(12L);
        petService.save(pet);

        Pet pet3 = new Pet();
        pet3.setId(3L);
        petService.save(pet3);

        given(petService.findById(anyLong())).willReturn(pet3);

        //when
        Visit visit2 = visitController.loadPetWithVisit(12L, model);

        //then
        assertThat(visit2).isNotNull();
        assertThat(visit2.getPet()).isNotNull();
        assertThat(visit2.getPet().getId()).isEqualTo(3L); //expected is 3L

        verify(petService, times(1)).findById(anyLong());
    }

}