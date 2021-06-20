package com.michi.productservice.controller;

import com.michi.commons.FoodWasteProduct;
import com.michi.productservice.repository.FoodWasteProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/foodWaste")
public class FoodWasteProductController {

    FoodWasteProductRepository foodWasteProductRepository;

    public FoodWasteProductController(FoodWasteProductRepository foodWasteProductRepository) {
        this.foodWasteProductRepository = foodWasteProductRepository;
    }

    @GetMapping
    public List<FoodWasteProduct> getAllProducts() {
        return foodWasteProductRepository.findAll();
    }


}
