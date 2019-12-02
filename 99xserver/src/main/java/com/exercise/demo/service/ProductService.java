package com.exercise.demo.service;

import com.exercise.demo.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * Product Service Class
 */

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ResponseEntity getProducts() {
        return new ResponseEntity(productRepository.findAll(), HttpStatus.OK);
    }
}
