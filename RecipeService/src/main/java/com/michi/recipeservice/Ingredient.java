package com.michi.recipeservice;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Ingredient {

    @Id
    private String id;
    private String name;
    private double price;
    private double pricePerKilo;


}
