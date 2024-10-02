package com.vladproduction.migrationjunit4junit5.dataloader;

import com.vladproduction.migrationjunit4junit5.entity.Ingredient;
import com.vladproduction.migrationjunit4junit5.entity.Pizza;
import static com.vladproduction.migrationjunit4junit5.entity.PortionSize.*;
import com.vladproduction.migrationjunit4junit5.repository.IngredientRepository;
import com.vladproduction.migrationjunit4junit5.repository.PizzaRepository;
import com.vladproduction.migrationjunit4junit5.service.IngredientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Component
@AllArgsConstructor
@Slf4j
public class ContentAppLoader implements ApplicationListener<ContextRefreshedEvent> {

    private PizzaRepository pizzaRepository;

    private IngredientRepository ingredientRepository;

    private IngredientService ingredientService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("ContentAppLoader is up.....");
        log.info("IngredientContent is up.");
        ingredientRepository.saveAll(getIngredientContent());
        log.info("PizzaContent is up.");
        pizzaRepository.saveAll(getPizzaContent());
    }

    private List<Ingredient> getIngredientContent() {
        List<Ingredient> ingredients = new ArrayList<>(10);
        //ingredients:
        Ingredient cheese = new Ingredient(1L, "cheese");
        Ingredient chicken = new Ingredient(2L, "chicken");
        Ingredient pineapple = new Ingredient(3L, "pineapple");
        Ingredient tomato = new Ingredient(4L, "tomato");
        Ingredient salami = new Ingredient(5L, "salami");
        Ingredient bacon = new Ingredient(6L, "bacon");
        Ingredient mushrooms = new Ingredient(7L, "mushrooms");

        ingredients.add(cheese);
        ingredients.add(chicken);
        ingredients.add(pineapple);
        ingredients.add(tomato);
        ingredients.add(salami);
        ingredients.add(bacon);

        return ingredients;
    }

    private List<Pizza> getPizzaContent(){
        List<Pizza> pizzas = new ArrayList<>(5);

        //create pizzas:
        Pizza pizza1 = new Pizza();
        pizza1.setId(1L);
        pizza1.setName("Hawaii");
        pizza1.setDescription("Hawaiian traditional pizza");
        pizza1.setPrice(10.50);
        pizza1.setPortionSize(SMALL);
        pizza1.addIngredient(ingredientService.findByDescription("cheese"));
        pizza1.addIngredient(ingredientService.findByDescription("chicken"));
        pizza1.addIngredient(ingredientService.findByDescription("pineapple"));
        pizzas.add(pizza1);

        Pizza pizza2 = new Pizza();
        pizza2.setId(2L);
        pizza2.setName("Peperoni");
        pizza2.setDescription("Peperoni pizza");
        pizza2.setPrice(12.50);
        pizza2.setPortionSize(MEDIUM);
        pizza2.addIngredient(ingredientService.findByDescription("cheese"));
        pizza2.addIngredient(ingredientService.findByDescription("tomato"));
        pizza2.addIngredient(ingredientService.findByDescription("salami"));
        pizzas.add(pizza2);

        Pizza pizza3 = new Pizza();
        pizza3.setId(3L);
        pizza3.setName("NewYork");
        pizza3.setDescription("NewYork pizza");
        pizza3.setPrice(22.50);
        pizza3.setPortionSize(HUGE);
        pizza3.addIngredient(ingredientService.findByDescription("cheese"));
        pizza3.addIngredient(ingredientService.findByDescription("tomato"));
        pizza3.addIngredient(ingredientService.findByDescription("bacon"));
        pizza3.addIngredient(ingredientService.findByDescription("chicken"));
        pizza3.addIngredient(ingredientService.findByDescription("salami"));
        pizzas.add(pizza3);

        return pizzas;
    }

}
