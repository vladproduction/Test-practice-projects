package com.vladproduction.controllers;

import com.vladproduction.model.Pet;
import com.vladproduction.model.Visit;
import com.vladproduction.services.PetService;
import com.vladproduction.services.VisitService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class VisitControllerTest {
    @Mock
    VisitService visitService;
    @Mock
    PetService petService;
    @InjectMocks
    VisitController visitController;

    @Test
    public void loadPetWithVisit() {
        //given
        Map<String, Object> model = new HashMap<>();
        Pet pet = new Pet();
        pet.setId(1L);
        given(petService.findById(anyLong())).willReturn(pet);

        //when
        Visit visit = visitController.loadPetWithVisit(1L, model);

        //then
        assertThat(visit).isNotNull();
        assertThat(visit.getPet()).isNotNull();

    }
}