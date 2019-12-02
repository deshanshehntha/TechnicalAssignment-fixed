package com.exercise.demo.controller;

import com.exercise.demo.model.CalculatedPriceRequestObject;
import com.exercise.demo.service.ServiceHandler;
import com.exercise.demo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller end point of all
 * requests
 * This class will patch the request to service handler
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private ServiceHandler serviceHandler;

    @GetMapping("/getHorseshoePriceList")
    public ResponseEntity priceDataHorseshoe(){
        return serviceHandler.handleReq(Constants.GET_HORSESHOE_PRICE_LIST, new Object());
    }

    @GetMapping("/getPenguiEarsPriceList")
    public ResponseEntity priceDataPenguinEars(){
        return serviceHandler.handleReq(Constants.GET_PENGUIN_PRICE_LIST, new Object());
    }

    @GetMapping("/getProductsList")
    public ResponseEntity getProductData(){
        return serviceHandler.handleReq(Constants.GET_PRODUCT_DATA, new Object());
    }

    @PostMapping("/getCalculatedPrice")
    public ResponseEntity getUserData(@RequestBody CalculatedPriceRequestObject obj) {
        System.out.println(obj);
        return serviceHandler.handleReq(Constants.GET_CALCULATED_PRICE,obj);
    }





}
