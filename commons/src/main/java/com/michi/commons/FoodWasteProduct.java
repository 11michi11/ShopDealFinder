package com.michi.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class FoodWasteProduct {

    @Id
    private String name;
    private double price;
    private double discount;
    private String image;



}
