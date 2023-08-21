package recipe_application.com.cydeo.repository;

import org.springframework.stereotype.Component;
import recipe_application.com.cydeo.model.Recipe;

import java.util.ArrayList;
import java.util.List;
@Component
public class RecipeRepositoryImpl implements RecipeRepository{

    List<Recipe> recipeList = new ArrayList<>();

    @Override
    public boolean save(Recipe recipe) {
        recipeList.add(recipe);
        return true;
    }
}
