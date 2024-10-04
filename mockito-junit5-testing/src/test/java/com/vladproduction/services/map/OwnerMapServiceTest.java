package com.vladproduction.services.map;

import com.vladproduction.model.Owner;
import com.vladproduction.model.PetType;
import com.vladproduction.services.PetService;
import com.vladproduction.services.PetTypeService;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Owner Map Service Test - Major_Position")
public class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    PetTypeService petTypeService;
    PetService petService;

    @BeforeEach
    public void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);

        System.out.println("Before Each FIRST: OwnerMapServiceTest");
    }

    @DisplayName("Verify Zero Owners")
    @Test
    public void testOwnersAreZero(){
        int ownerCount = ownerMapService.findAll().size();
        assertThat(ownerCount).isZero();
    }

    @DisplayName("Pet Type - NestedClass:TestCreatePetTypes")
    @Nested
    class TestCreatePetTypes{

        @BeforeEach
        void setUp() {
            PetType petType1 = new PetType(1L, "Dog");
            PetType petType2 = new PetType(2L, "Cat");
            petTypeService.save(petType1);
            petTypeService.save(petType2);

            System.out.println("Before Each NESTED: TestCreatePetTypes");
        }

        @Test
        public void testPetCount(){
            int petTypeCount = petTypeService.findAll().size();
            assertThat(petTypeCount).isNotZero().isEqualTo(2);
        }

        @DisplayName("Save Owners Tests - NestedClass: SaveOwnersTests")
        @Nested
        class SaveOwnersTests{
            @BeforeEach
            void setUp() {
                ownerMapService.save(new Owner(1L, "Before", "Each"));
                System.out.println("Save Owner (Before Each)");
            }
            @Test
            public void saveOwner(){
                Owner owner = new Owner(2L, "John", "Doe");
                Owner savedOwner = ownerMapService.save(owner);
                assertThat(savedOwner).isNotNull();
            }

            @DisplayName("Find Owners Tests - NestedClass: FindOwnersTests")
            @Nested
            class FindOwnersTests{

                @DisplayName("Find Owner Test")
                @Test
                public void testFindOwner(){
                    Owner foundOwner = ownerMapService.findById(1L);
                    assertThat(foundOwner).isNotNull();
                }

                @DisplayName("Find Owner Not Found Test")
                @Test
                public void testFindOwnerNotFound(){
                    Owner foundOwner = ownerMapService.findById(2L);
                    assertThat(foundOwner).isNull();
                }

            }
        }


    }

    @DisplayName("Verify Still Zero Owners - ")
    @Test
    public void testOwnersAreStillZero(){
        int ownerCount = ownerMapService.findAll().size();
        assertThat(ownerCount).isZero();
    }
}