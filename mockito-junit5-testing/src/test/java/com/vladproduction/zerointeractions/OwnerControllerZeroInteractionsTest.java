package com.vladproduction.zerointeractions;

import com.vladproduction.controllers.OwnerController;
import com.vladproduction.fauxspring.BindingResult;
import com.vladproduction.fauxspring.Model;
import com.vladproduction.model.Owner;
import com.vladproduction.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerZeroInteractionsTest {
    @Mock
    OwnerService ownerService;
    @Mock
    Model model;
    @InjectMocks
    OwnerController ownerController;
    @Mock
    BindingResult bindingResult;
    @Captor
    ArgumentCaptor<String> captorStrings;

    @BeforeEach
    void setUp() {
        given(ownerService.findAllByLastNameLike(captorStrings.capture()))
                .willAnswer(invocation -> {
                    List<Owner> owners = new ArrayList<>();

                    String name = invocation.getArgument(0);

                    switch (name) {
                        case "%Buck%":
                            owners.add(new Owner(1l, "Joe", "Buck"));
                            return owners;
                        case "%DontFindMe%":
                            return owners;
                        case "%FindMe%":
                            owners.add(new Owner(1l, "Joe", "Buck"));
                            owners.add(new Owner(2l, "Joe2", "Buck2"));
                            return owners;
                    }

                    throw new RuntimeException("Invalid Argument");
                });
    }


    @Test
    void processFindFormWildcardFound() {
        //given
        Owner owner = new Owner(1l, "Joe", "FindMe");
        InOrder inOrder = inOrder(ownerService, model);

        //when
        String viewName = ownerController.processFindForm(owner, bindingResult, model);

        //then
        assertThat("%FindMe%").isEqualToIgnoringCase(captorStrings.getValue());
        assertThat("owners/ownersList").isEqualToIgnoringCase(viewName);

        // inorder asserts
        inOrder.verify(ownerService).findAllByLastNameLike(anyString());
        inOrder.verify(model, times(1)).addAttribute(anyString(), anyList());
        verifyNoMoreInteractions(model);
    }

    @Test
    void processFindFormWildcardStringAnnotation() {
        //given
        Owner owner = new Owner(1l, "Joe", "Buck");

        //when
        String viewName = ownerController.processFindForm(owner, bindingResult, null);

        //then
        assertThat("%Buck%").isEqualToIgnoringCase(captorStrings.getValue());
        assertThat("redirect:/owners/1").isEqualToIgnoringCase(viewName);
        verifyZeroInteractions(model);
    }


    @Test
    void processFindFormWildcardNotFound() {
        //given
        Owner owner = new Owner(1l, "Joe", "DontFindMe");

        //when
        String viewName = ownerController.processFindForm(owner, bindingResult, null);

        verifyNoMoreInteractions(ownerService);

        //then
        assertThat("%DontFindMe%").isEqualToIgnoringCase(captorStrings.getValue());
        assertThat("owners/findOwners").isEqualToIgnoringCase(viewName);
        verifyZeroInteractions(model);
    }


}