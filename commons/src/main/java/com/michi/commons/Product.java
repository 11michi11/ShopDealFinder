package com.michi.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Product {

    @Id
    private String name;
    private double price;
    private Unit unit;
    private double pricePerUnit;

}
