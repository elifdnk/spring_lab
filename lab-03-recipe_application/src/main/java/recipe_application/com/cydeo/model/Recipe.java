package recipe_application.com.cydeo.model;

import lombok.Getter;
import lombok.Setter;
import recipe_application.com.cydeo.enums.RecipeType;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
public class Recipe {
    private UUID recipeId;
    private String name;
    private int duration;
    private String preparation;
    private List<Ingredient> ingredients;
    private RecipeType recipeType;


}
