package recipe_application.com.cydeo.model;

import lombok.Getter;
import lombok.Setter;
import recipe_application.com.cydeo.enums.QuantityType;
@Getter
@Setter
public class Ingredient {
    private String name;
    private int quantity;
    private QuantityType quantityType;

}
