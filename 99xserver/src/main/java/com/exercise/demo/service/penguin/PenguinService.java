package com.exercise.demo.service.penguin;

import com.exercise.demo.dao.ProductRepository;
import com.exercise.demo.model.CalculatedPriceRequestObject;
import com.exercise.demo.service.PriceContext;
import com.exercise.demo.service.PriceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 *Penguin Service Class
 *
 *
 */

@Service
public class PenguinService {

    @Autowired
    ProductRepository productRepository;

    public ResponseEntity getPenguinPriceList() {
        PriceContext context = new PriceContext(new PenguinPrice());
        return new ResponseEntity(context.executeStatergy(productRepository.getProductByProductName("PenguinEars")), HttpStatus.OK);
    }

    public ResponseEntity getCalculatedPrice(CalculatedPriceRequestObject obj) {
        return new ResponseEntity(new PriceGenerator().getCalculatedPrice(obj,
                productRepository.getProductByProductName("PenguinEars")), HttpStatus.OK);
    }
}
