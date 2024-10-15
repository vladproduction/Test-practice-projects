package org.springframework.samples.petclinic.web;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//setting up web context for us
@ExtendWith(MockitoExtension.class)
@SpringJUnitWebConfig(locations = {"classpath:spring/mvc-test-config.xml", "classpath:spring/mvc-core-config.xml"})
class OwnerControllerTest {

    @Autowired
    OwnerController ownerController;

    @Autowired
    ClinicService clinicService;

    MockMvc mockMvc;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    public void testLoadContentUp(){
        // should pass
    }

    @Test
    public void testOwnerControllerInitCreationForm() throws Exception {
        mockMvc.perform(get("/owners/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(view().name("owners/createOrUpdateOwnerForm"));
    }

    @Test
    public void testFindByNameNotFound() throws Exception {
        mockMvc.perform(get("/owners")
                    .param("lastName", "do not find me!"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"));
        /*this part of code we are testing: and we say to mockito return nothing; so test is correct and pass;
        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";*/
    }

    //test cases cover in assignment (parts of code):
    /*1)// allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
        owner.setLastName(""); // empty string signifies broadest possible search}*/
    //and
    /*2)else {
        // multiple owners found
        model.put("selections", results);
        return "owners/ownersList";}*/
    @Test
    public void testReturnListOfOwners() throws Exception {
        given(clinicService.findOwnerByLastName("")).willReturn(Lists.newArrayList(new Owner(), new Owner()));

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"));

        then(clinicService).should().findOwnerByLastName(stringArgumentCaptor.capture());

        //combination of location xml files and Captor annotation is work for context if we add: @ExtendWith(MockitoExtension.class)
        assertThat(stringArgumentCaptor.getValue()).isEqualToIgnoringCase("");
    }

    //test case cover in assignment (part of code):
    /*else if (results.size() == 1) {
        // 1 owner found
        owner = results.iterator().next();
        return "redirect:/owners/" + owner.getId();}*/
    @Test
    public void testFindOwnerOneResult() throws Exception {
        Owner justOne = new Owner();
        justOne.setId(1);
        final String findJustOne = "FindJustOne";
        justOne.setLastName(findJustOne);
        given(clinicService.findOwnerByLastName(findJustOne)).willReturn(Lists.newArrayList(justOne));

        mockMvc.perform(get("/owners")
                        .param("lastName", "FindJustOne"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));

        then(clinicService).should().findOwnerByLastName(anyString());
    }

    //testNewOwnerPostValid() --> this part of code:
    /*@RequestMapping(value = "/owners/new", method = RequestMethod.POST)
    public String processCreationForm(@Valid Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            this.clinicService.saveOwner(owner);
            return "redirect:/owners/" + owner.getId();
        }
    }*/
    @Test
    public void testNewOwnerPostValid() throws Exception {
        //need to have valid parameters (by entity fields are defined)
        Owner newOwnerPosting = new Owner();
        newOwnerPosting.setFirstName("John");
        newOwnerPosting.setLastName("Doe");
        newOwnerPosting.setAddress("Address1");
        newOwnerPosting.setCity("City");
        newOwnerPosting.setTelephone("1234567890");

        mockMvc.perform(post("/owners/new")
                        .param("firstName", newOwnerPosting.getFirstName())
                        .param("lastName", newOwnerPosting.getLastName())
                        .param("address", newOwnerPosting.getAddress())
                        .param("city", newOwnerPosting.getCity())
                        .param("telephone", newOwnerPosting.getTelephone()))
                .andExpect(status().is3xxRedirection());

    }

    @AfterEach
    public void tearDown() {
        //need to have to avoid reusing data through mockito testing content
        reset(clinicService);
    }
}


















