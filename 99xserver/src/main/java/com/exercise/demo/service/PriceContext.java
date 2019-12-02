package com.exercise.demo.service;

import com.exercise.demo.model.PriceTableResponseObject;
import com.exercise.demo.model.Product;
import java.util.ArrayList;

/**
 *Used Statergy Pattern in case of future changes
 *
 * Context Class
 *
 */

public class PriceContext {

    private PriceEngine engine;

    public PriceContext(PriceEngine engine) {
        this.engine = engine;
    }

    public ArrayList<PriceTableResponseObject> executeStatergy(Product product) {
        return engine.generatePriceList(product);
    }

}

