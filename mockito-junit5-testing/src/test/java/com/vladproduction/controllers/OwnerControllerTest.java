package com.vladproduction.controllers;

import com.vladproduction.fauxspring.BindingResult;
import com.vladproduction.model.Owner;
import com.vladproduction.services.OwnerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
    private static final String CREATE_OR_UPDATE_OWNER_FORM = "owners/createOrUpdateOwnerForm";
    private static final String REDIRECT_OWNERS_5 = "redirect:/owners/5";
    @Mock
    OwnerService ownerService;
    @InjectMocks
    OwnerController ownerController;
    @Mock
    BindingResult bindingResult;
    @Captor
    ArgumentCaptor<String> captorStrings;


    @Test
    public void testProcessFindFormWildcardsString(){
        //given
        Owner owner = new Owner(1L, "John", "Doe");
        List<Owner> ownerList = new ArrayList<>();
        final ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        given(ownerService.findAllByLastNameLike(captor.capture())).willReturn(ownerList);

        //when
        String viewName = ownerController.processFindForm(owner, bindingResult, null);

        //then
        assertThat("%Doe%").isEqualToIgnoringCase(captor.getValue());
    }

    @Test
    public void testProcessFindFormWildcardsStringAnnotation(){
        //given
        Owner owner = new Owner(1L, "John", "Doe");
        List<Owner> ownerList = new ArrayList<>();

        given(ownerService.findAllByLastNameLike(captorStrings.capture())).willReturn(ownerList);

        //when
        String viewName = ownerController.processFindForm(owner, bindingResult, null);

        //then
        assertThat("%Doe%").isEqualToIgnoringCase(captorStrings.getValue());
    }

    @Test
    public void testProcessCreationFormHasErrors() {
        //given
        Owner owner = new Owner(1L, "John", "Doe");
        given(bindingResult.hasErrors()).willReturn(true);

        //when
        String viewName = ownerController.processCreationForm(owner, bindingResult);

        //then
        assertThat(viewName).isEqualToIgnoringCase(CREATE_OR_UPDATE_OWNER_FORM);


    }

    @Test
    public void testProcessCreationFormNoErrors() {
        //given
        Owner owner = new Owner(5L, "John", "Doe");
        given(bindingResult.hasErrors()).willReturn(false);
        given(ownerService.save(any())).willReturn(owner);

        //when
        String viewName = ownerController.processCreationForm(owner, bindingResult);

        //then
        assertThat(viewName).isEqualToIgnoringCase(REDIRECT_OWNERS_5);
    }
}