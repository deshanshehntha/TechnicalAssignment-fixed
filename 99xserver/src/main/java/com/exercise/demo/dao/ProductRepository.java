package com.exercise.demo.dao;

import com.exercise.demo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created By DeshanW
 *
 * Connection DAO to mongo cluster repositiory
 **/

public interface ProductRepository extends MongoRepository<Product, String> {
    public Product getProductByProductName(String name);
}
