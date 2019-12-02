package com.exercise.demo.service.horseshoe;

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

public class HorseShoePrice implements PriceEngine {

    @Override
    public ArrayList<PriceTableResponseObject> generatePriceList(Product product) {
        PriceGenerator priceGenerator = new PriceGenerator();
        return priceGenerator.generatePriceList(product);
    }
}
