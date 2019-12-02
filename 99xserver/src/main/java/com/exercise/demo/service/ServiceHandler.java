package com.exercise.demo.service;

import com.exercise.demo.model.CalculatedPriceRequestObject;
import com.exercise.demo.service.horseshoe.HorseshoePriceService;
import com.exercise.demo.service.penguin.PenguinService;
import com.exercise.demo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Service Handler Factory
 *
 * Services are acting as singleton
 *
 */


@Component
public class ServiceHandler {

    @Autowired
    private HorseshoePriceService horseshoePriceService;

    @Autowired
    private PenguinService penguinService;
    @Autowired
    private ProductService productService;

    public ResponseEntity handleReq(String reqType, Object obj) {
        switch (reqType) {
            case Constants.GET_HORSESHOE_PRICE_LIST:
                return getHorseshoePriceList();
            case Constants.GET_PENGUIN_PRICE_LIST:
                return getPenguinPriceList();
            case Constants.GET_PRODUCT_DATA:
                return getProductData();
            case Constants.GET_CALCULATED_PRICE:
                return getCalculatedPrice((CalculatedPriceRequestObject) obj);
            default:
                return new ResponseEntity("Failed Generate", HttpStatus.OK);
        }
    }

    private ResponseEntity getHorseshoePriceList() {
        return horseshoePriceService.getHorseshoePriceList();
    }

    private ResponseEntity getPenguinPriceList() {
        return penguinService.getPenguinPriceList();
    }

    private ResponseEntity getProductData() {
        return productService.getProducts();
    }

    private ResponseEntity getCalculatedPrice(CalculatedPriceRequestObject obj) {
        if (obj.getProduct().equals(Constants.HORESESHOE)) {
            return horseshoePriceService.getCalculatedPrice(obj);
        } else {
            return penguinService.getCalculatedPrice(obj);
        }
    }

}
