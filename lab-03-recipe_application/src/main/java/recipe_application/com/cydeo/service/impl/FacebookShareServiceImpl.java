package recipe_application.com.cydeo.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import recipe_application.com.cydeo.model.Recipe;
import recipe_application.com.cydeo.service.ShareService;

@Component
@Primary
public class FacebookShareServiceImpl implements ShareService {
    @Override
    public boolean share(Recipe recipe) {
        System.out.println("Shared on facebook");
        System.out.println("RecipeType: " + recipe.getRecipeType());
        System.out.println("Recipe Name " + recipe.getName() );
        System.out.println("Ingredient List ");
        recipe.getIngredients().forEach(ingredients -> {
            System.out.println("    Ingredient Name " + ingredients.getName() + " Quantity : " + ingredients.getQuantity() +
                    " " + ingredients.getQuantityType());
        });
        System.out.println("Preperation: \n" + "\t" + recipe.getPreparation());

        return true;
    }
}