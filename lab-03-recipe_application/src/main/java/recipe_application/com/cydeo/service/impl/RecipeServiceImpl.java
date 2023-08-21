package recipe_application.com.cydeo.service.impl;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;
import recipe_application.com.cydeo.enums.QuantityType;
import recipe_application.com.cydeo.enums.RecipeType;
import recipe_application.com.cydeo.model.Ingredient;
import recipe_application.com.cydeo.model.Recipe;
import recipe_application.com.cydeo.repository.RecipeRepository;
import recipe_application.com.cydeo.service.RecipeService;
import recipe_application.com.cydeo.service.ShareService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final ShareService shareService;
    private final Faker faker;

    public RecipeServiceImpl(RecipeRepository recipeRepository, ShareService shareService, Faker faker) {
        this.recipeRepository = recipeRepository;
        this.shareService = shareService;
        this.faker = faker;
    }


    @Override
    public boolean prepareRecipe() {
        //create one recipe object
        Recipe recipe =new Recipe();
        //set the fields
        recipe.setRecipeId(UUID.randomUUID());
        recipe.setName(faker.food().dish());
        recipe.setDuration(faker.number().numberBetween(1,20));
        recipe.setPreparation(faker.lorem().paragraph(5));
        recipe.setIngredients(prepareIngredient());
        recipe.setRecipeType(RecipeType.BREAKFAST);
        //save recipe
        recipeRepository.save(recipe);
        //share recipe
        shareService.share(recipe);
        //return true
        return true;
    }

    private int generateRandomValue(){return new Random().nextInt(20)+1;}

    private List<Ingredient> prepareIngredient (){
        List<Ingredient> ingredientsList = new ArrayList<>();
        for (int i = 0; i < generateRandomValue(); i++) {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(faker.food().ingredient());
            ingredient.setQuantity(generateRandomValue());
            ingredient.setQuantityType(QuantityType.TBSP);
            ingredientsList.add(ingredient);
        }
        return ingredientsList;
    }




}
