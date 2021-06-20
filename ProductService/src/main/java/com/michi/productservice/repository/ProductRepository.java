package com.michi.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.michi.commons.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}
