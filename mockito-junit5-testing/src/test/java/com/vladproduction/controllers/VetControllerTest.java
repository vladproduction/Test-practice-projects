package com.vladproduction.controllers;

import com.vladproduction.ControllersTest;
import com.vladproduction.fauxspring.Model;
import com.vladproduction.fauxspring.ModelMapImpl;
import com.vladproduction.model.Vet;
import com.vladproduction.services.SpecialtyService;
import com.vladproduction.services.VetService;
import com.vladproduction.services.map.SpecialityMapService;
import com.vladproduction.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@Tag("controller")
class VetControllerTest implements ControllersTest {

    VetService vetService;
    SpecialtyService specialtyService;
    VetController vetController;

    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);

        vetController = new VetController(vetService);

        Vet vet1 = new Vet(1L, "John", "Doe", null);
        Vet vet2 = new Vet(2L, "Mark", "Stone", null);

        vetService.save(vet1);
        vetService.save(vet2);
    }

    @Test
    void testListVets() {
        Model model = new ModelMapImpl();

        String view = vetController.listVets(model);

        assertThat("vets/index").isEqualTo(view);

        Set modelAttribute = (Set) ((ModelMapImpl) model).getMap().get("vets");

        assertThat(modelAttribute.size()).isEqualTo(2);
    }
}