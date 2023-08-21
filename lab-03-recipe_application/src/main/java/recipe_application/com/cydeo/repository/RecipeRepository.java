package recipe_application.com.cydeo.repository;

import recipe_application.com.cydeo.model.Recipe;

public interface RecipeRepository  {

   boolean save(Recipe recipe);
}
