package com.exercise.demo.service;

import com.exercise.demo.model.PriceTableResponseObject;
import com.exercise.demo.model.Product;
import java.util.ArrayList;

/**
 *
 *Used Statergy Pattern in case of future changes
 *
 *
 */

public interface PriceEngine {
    public ArrayList<PriceTableResponseObject> generatePriceList(Product product);
}
