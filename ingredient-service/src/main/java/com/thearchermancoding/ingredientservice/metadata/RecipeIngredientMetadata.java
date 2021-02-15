package com.thearchermancoding.ingredientservice.metadata;

import com.thearchermancoding.ingredientservice.model.Ingredient;
import com.thearchermancoding.ingredientservice.model.MeasuringUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeIngredientMetadata extends RepresentationModel<RecipeIngredientMetadata> {

    private String name;

    private String description;

    private String unitName;

    private String unitVariable;

    private float amount;

    public void setIngredient(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.description = ingredient.getDescription();
    }

    public void setUnit(MeasuringUnit unit) {
        this.unitVariable = unit.getUnitVariable();
        this.unitName = unit.getUnitName();
    }

}
