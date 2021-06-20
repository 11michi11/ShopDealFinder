package com.michi.recipeservice;


import com.michi.commons.Product;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
public class Ingredient {

    @DBRef
    private Product product;
    private double amount;
    private Unit unit;

    public Ingredient(Product product, double amount, Unit unit) {
        this.product = product;
        this.amount = amount;
        this.unit = unit;
    }
}
