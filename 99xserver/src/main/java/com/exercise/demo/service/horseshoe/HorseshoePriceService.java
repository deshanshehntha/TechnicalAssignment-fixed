package com.exercise.demo.service.horseshoe;

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
 Horseshoe Service Class
 *
 *
 */

@Service
public class HorseshoePriceService {


    @Autowired
    ProductRepository productRepository;

    public ResponseEntity getHorseshoePriceList() {
        PriceContext context = new PriceContext(new HorseShoePrice());
        return new ResponseEntity(context.executeStatergy(productRepository.getProductByProductName("Horseshoe")), HttpStatus.OK);
    }

    public ResponseEntity getCalculatedPrice(CalculatedPriceRequestObject obj) {
        return new ResponseEntity(new PriceGenerator().getCalculatedPrice(obj,
                productRepository.getProductByProductName("Horseshoe")), HttpStatus.OK);
    }
}
