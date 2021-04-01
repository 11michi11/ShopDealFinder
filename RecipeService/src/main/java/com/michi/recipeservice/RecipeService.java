package com.michi.recipeservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping
    public List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }

    @PostMapping
    public void saveRecipe(@RequestBody Recipe recipe) {
        recipeRepository.save(recipe);
    }

}
