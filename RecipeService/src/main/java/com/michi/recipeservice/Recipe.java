package com.michi.recipeservice;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Recipe {

    @Id
    private String id;
    private List<Ingredient> ingredients;
    private String preparation;


}
