package com.vladproduction.migrationjunit4junit5.dataloader;

import com.vladproduction.migrationjunit4junit5.entity.Ingredient;
import com.vladproduction.migrationjunit4junit5.entity.Pizza;
import static com.vladproduction.migrationjunit4junit5.entity.PortionSize.*;

import com.vladproduction.migrationjunit4junit5.exceptions.IngredientByDescriptionNotFoundException;
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
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("ContentAppLoader is up.....");

        log.info("IngredientContent is up.");
        List<Ingredient> ingredients = ingredientRepository.saveAll(getIngredientContent()); // Save and retrieve managed instances

        log.info("PizzaContent is up.");
        pizzaRepository.saveAll(getPizzaContent(ingredients));
    }

    private List<Ingredient> getIngredientContent() {
        List<Ingredient> ingredients = new ArrayList<>(10);
        // Adding ingredients without IDs
        ingredients.add(new Ingredient(null, "cheese"));
        ingredients.add(new Ingredient(null, "chicken"));
        ingredients.add(new Ingredient(null, "pineapple"));
        ingredients.add(new Ingredient(null, "tomato"));
        ingredients.add(new Ingredient(null, "salami"));
        ingredients.add(new Ingredient(null, "bacon"));
        ingredients.add(new Ingredient(null, "mushrooms"));

        return ingredients;
    }

    private List<Pizza> getPizzaContent(List<Ingredient> ingredients){

        List<Pizza> pizzas = new ArrayList<>(3);

        //create pizzas with ingredients passed as an argument
        Pizza pizza1 = new Pizza();
        pizza1.setName("Hawaii");
        pizza1.setDescription("Hawaiian pizza");
        pizza1.setPrice(10.50);
        pizza1.setPortionSize(SMALL);
        pizza1.setIngredients(new ArrayList<>(List.of(
                ingredients.stream().filter(i -> i.getDescription().equals("cheese")).findFirst()
                        .orElseThrow(() -> new IngredientByDescriptionNotFoundException("Such ingredient does not exist")),
                ingredients.stream().filter(i -> i.getDescription().equals("chicken")).findFirst()
                        .orElseThrow(() -> new IngredientByDescriptionNotFoundException("Such ingredient does not exist")),
                ingredients.stream().filter(i -> i.getDescription().equals("pineapple")).findFirst()
                        .orElseThrow(() -> new IngredientByDescriptionNotFoundException("Such ingredient does not exist"))
        )));
        pizzas.add(pizza1);

        Pizza pizza2 = new Pizza();
        pizza2.setName("Peperoni");
        pizza2.setDescription("Peperoni pizza");
        pizza2.setPrice(12.50);
        pizza2.setPortionSize(MEDIUM);
        pizza2.setIngredients(new ArrayList<>(List.of(
                ingredients.stream().filter(i -> i.getDescription().equals("cheese")).findFirst()
                        .orElseThrow(() -> new IngredientByDescriptionNotFoundException("Such ingredient does not exist")),
                ingredients.stream().filter(i -> i.getDescription().equals("tomato")).findFirst()
                        .orElseThrow(() -> new IngredientByDescriptionNotFoundException("Such ingredient does not exist")),
                ingredients.stream().filter(i -> i.getDescription().equals("salami")).findFirst()
                        .orElseThrow(() -> new IngredientByDescriptionNotFoundException("Such ingredient does not exist"))
        )));
        pizzas.add(pizza2);

        Pizza pizza3 = new Pizza();
        pizza3.setId(3L);
        pizza3.setName("NewYork");
        pizza3.setDescription("NewYork pizza");
        pizza3.setPrice(22.50);
        pizza3.setPortionSize(HUGE);
        pizza3.setIngredients(new ArrayList<>(List.of(
                ingredients.stream().filter(i -> i.getDescription().equals("cheese")).findFirst()
                        .orElseThrow(() -> new IngredientByDescriptionNotFoundException("Such ingredient does not exist")),
                ingredients.stream().filter(i -> i.getDescription().equals("chicken")).findFirst()
                        .orElseThrow(() -> new IngredientByDescriptionNotFoundException("Such ingredient does not exist")),
                ingredients.stream().filter(i -> i.getDescription().equals("salami")).findFirst()
                        .orElseThrow(() -> new IngredientByDescriptionNotFoundException("Such ingredient does not exist")),
                ingredients.stream().filter(i -> i.getDescription().equals("mushrooms")).findFirst()
                        .orElseThrow(() -> new IngredientByDescriptionNotFoundException("Such ingredient does not exist")),
                ingredients.stream().filter(i -> i.getDescription().equals("tomato")).findFirst()
                        .orElseThrow(() -> new IngredientByDescriptionNotFoundException("Such ingredient does not exist")),
                ingredients.stream().filter(i -> i.getDescription().equals("bacon")).findFirst()
                        .orElseThrow(() -> new IngredientByDescriptionNotFoundException("Such ingredient does not exist"))
        )));
        pizzas.add(pizza3);

        return pizzas;
    }

}
