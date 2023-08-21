package recipe_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import recipe_application.com.cydeo.config.AuthorConfig;
import recipe_application.com.cydeo.service.RecipeService;

@SpringBootApplication
public class RecipeApplication {

    public static void main(String[] args) {
       ApplicationContext container=  SpringApplication.run(RecipeApplication.class, args);

        RecipeService recipeService = container.getBean(RecipeService.class);
        recipeService.prepareRecipe();

        AuthorConfig authorConfig = container.getBean(AuthorConfig.class);
        System.out.println("name= "+authorConfig.getName());
        System.out.println("surname= " +authorConfig.getSurname());



    }

}
