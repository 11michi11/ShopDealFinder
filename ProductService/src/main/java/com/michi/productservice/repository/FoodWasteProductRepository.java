package com.michi.productservice.repository;

import com.michi.commons.FoodWasteProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodWasteProductRepository extends MongoRepository<FoodWasteProduct, String> {
}
