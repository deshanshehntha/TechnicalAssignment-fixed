package com.exercise.demo.service.penguin;

import com.exercise.demo.model.PriceTableResponseObject;
import com.exercise.demo.model.Product;
import com.exercise.demo.service.PriceEngine;
import com.exercise.demo.service.PriceGenerator;

import java.util.ArrayList;

/**
 *Used Statergy Pattern in case of future changes
 *
 * Context Class
 *
 */

public class PenguinPrice implements PriceEngine {

    @Override
    public ArrayList<PriceTableResponseObject> generatePriceList(Product product) {
        PriceGenerator priceGenerator = new PriceGenerator();
        return priceGenerator.generatePriceList(product);
    }
}

