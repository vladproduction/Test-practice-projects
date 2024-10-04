package com.vladproduction.mockitoanswer;

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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class OwnerControllerWillAnswerTest {
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

    @BeforeEach
    public void setUp() {
        //with switch case type:
        given(ownerService.findAllByLastNameLike(captorStrings.capture()))
                .willAnswer(invocationOnMock -> {
                    List<Owner> ownerList = new ArrayList<>();
                    String name = invocationOnMock.getArgument(0);
                    switch (name) {
                        case "%Doe%":
                            ownerList.add(new Owner(1L, "John", "Doe"));
                            return ownerList;
                        case "%Dont find me%":
                            return ownerList;
                        case "%Find me%":
                            ownerList.add(new Owner(1L, "John", "Doe"));
                            ownerList.add(new Owner(2L, "Johan", "Doherty"));
                            return ownerList;
                    }

                    throw new RuntimeException("Invalid argument");
                });


        /*given(ownerService.findAllByLastNameLike(captorStrings.capture()))
                .willAnswer(invocationOnMock -> {
                    List<Owner> ownerList = new ArrayList<>();
                    String name = invocationOnMock.getArgument(0);
                    if(name.equals("%Doe%")){
                        ownerList.add(new Owner(1L, "John", "Doe"));
                        return ownerList;
                    } else if (name.equals("%Dont find me%")) {
                        return ownerList;
                    } else if (name.equals("%Find me%")) {
                        ownerList.add(new Owner(1L, "John", "Doe"));
                        ownerList.add(new Owner(2L, "Johan", "Doherty"));
                        return ownerList;
                    }

                    throw new RuntimeException("Invalid argument");
                });*/
    }

    @Test
    public void testProcessWillAnswer() {
        //given
        Owner owner = new Owner(1L, "John", "Doe");

        //when
        String viewName = ownerController.processFindForm(owner, bindingResult, null);

        //then
        assertThat("%Doe%").isEqualToIgnoringCase(captorStrings.getValue());
        assertThat("redirect:/owners/1").isEqualToIgnoringCase(viewName);
    }

    @Test
    public void testProcessWillAnswer_NotFound() {
        //given
        Owner owner = new Owner(1L, "John", "Dont find me");

        //when
        String viewName = ownerController.processFindForm(owner, bindingResult, null);

        //then
        assertThat("%Dont find me%").isEqualToIgnoringCase(captorStrings.getValue());
        assertThat("owners/findOwners").isEqualToIgnoringCase(viewName);
    }

    @Test
    public void testProcessWillAnswer_Found() {
        //given
        Owner owner = new Owner(1L, "John", "Find me");

        //when
        String viewName = ownerController.processFindForm(owner, bindingResult, Mockito.mock(Model.class));

        //then
        assertThat("%Find me%").isEqualToIgnoringCase(captorStrings.getValue());
        assertThat("owners/ownersList").isEqualToIgnoringCase(viewName);
    }


}