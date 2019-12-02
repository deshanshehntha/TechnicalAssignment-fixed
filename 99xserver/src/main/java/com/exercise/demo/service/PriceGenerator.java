package com.exercise.demo.service;

import com.exercise.demo.model.CalculatedPriceRequestObject;
import com.exercise.demo.model.PriceTableResponseObject;
import com.exercise.demo.model.Product;
import com.exercise.demo.util.Constants;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * Common Calculator Class
 * <p>
 * Independent From Products
 */

public class PriceGenerator {


    public ArrayList<PriceTableResponseObject> generatePriceList(Product product) {
        ArrayList<PriceTableResponseObject> priceMap = new ArrayList<>();
        product.setSingleUnitPrice(getSingleUnitPrice(product.getUnitsPerCartoon(), product.getPricePerCartoon()));
        for (int i = 1; i <= 50; i++) {
            priceMap.add(generatePrice(i, product, product.getUnitsPerCartoon()));
        }
        return priceMap;
    }

    private synchronized PriceTableResponseObject generatePrice(int qty, Product product, int unitesPerCar) {
        if ((qty % unitesPerCar) == 0) {
            BigDecimal noOfCartoons = new BigDecimal(qty);
            BigDecimal numberOfCtn = noOfCartoons.divide(BigDecimal.valueOf(unitesPerCar),3, RoundingMode.CEILING);

            PriceTableResponseObject obj = new PriceTableResponseObject();
            obj.setType(product.getProductName());
            obj.setNoOfUnits(qty);
            if ((noOfCartoons.intValue()/unitesPerCar) > 3) {
                obj.setPrice(Constants.twoDecimalFormatter(
                        numberOfCtn.multiply(BigDecimal.valueOf(product.getPricePerCartoon())).multiply(BigDecimal.valueOf(0.9)).doubleValue()));
                obj.setSurCharge(obj.getPrice() - (product.getPricePerCartoon()*unitesPerCar));
            } else {
                obj.setPrice(Constants.twoDecimalFormatter(numberOfCtn.multiply(BigDecimal.valueOf(product.getPricePerCartoon())).doubleValue()));
                obj.setSurCharge(obj.getPrice() - (product.getPricePerCartoon() / product.getUnitsPerCartoon())*obj.getNoOfUnits());
            }
            return obj;
        } else {
            MathContext mc = new MathContext(5); // 2 precision

            BigDecimal noOfCartoons = new BigDecimal(qty);
            BigDecimal numberOfCtn = noOfCartoons.divide(BigDecimal.valueOf(unitesPerCar),3, RoundingMode.CEILING);
            BigDecimal noOfSingleUnits = new BigDecimal(qty);
            BigDecimal singleUni = noOfSingleUnits.subtract(numberOfCtn.multiply(BigDecimal.valueOf(unitesPerCar)),mc);

            double totalPrice;
            if (numberOfCtn.intValue() > 3) {
                BigDecimal noCtn = numberOfCtn.multiply(BigDecimal.valueOf(product.getPricePerCartoon())).multiply(BigDecimal.valueOf(0.9));
                totalPrice = noCtn.add(singleUni.multiply(BigDecimal.valueOf(product.getSingleUnitPrice()))).doubleValue();


            } else {
                numberOfCtn = numberOfCtn.multiply(BigDecimal.valueOf(product.getPricePerCartoon()));
                totalPrice = numberOfCtn.add(singleUni.multiply(BigDecimal.valueOf(product.getSingleUnitPrice()))).doubleValue();
            }
            PriceTableResponseObject obj = new PriceTableResponseObject();
            obj.setType(product.getProductName());
            obj.setNoOfUnits(qty);
            obj.setPrice(Constants.twoDecimalFormatter(totalPrice));
            double priceWithoutSurCharge = new BigDecimal(product.getSingleUnitPrice()).multiply(
                    BigDecimal.valueOf(obj.getNoOfUnits())).doubleValue();
            obj.setSurCharge(Constants.twoDecimalFormatter(new BigDecimal(totalPrice).subtract(BigDecimal.valueOf(priceWithoutSurCharge)).doubleValue()));
            return obj;
        }
    }


    public PriceTableResponseObject getCalculatedPrice(CalculatedPriceRequestObject obj, Product product) {
        PriceTableResponseObject responseObject = new PriceTableResponseObject();
        if (obj.isQtyType()) {
            if (Integer.parseInt(obj.getQty()) > 3) {
                responseObject.setPrice(new BigDecimal(obj.getQty()).multiply(BigDecimal.valueOf(
                        product.getPricePerCartoon())).multiply(BigDecimal.valueOf(0.9)).doubleValue());
                responseObject.setSurCharge(responseObject.getPrice() - (product.getPricePerCartoon() / product.getUnitsPerCartoon()));
                return responseObject;
            } else {
                responseObject.setPrice(new BigDecimal(obj.getQty()).multiply(BigDecimal.valueOf(product.getPricePerCartoon())).doubleValue());
                responseObject.setSurCharge(responseObject.getPrice() - (product.getPricePerCartoon() / product.getUnitsPerCartoon()));
                return responseObject;
            }
        } else {
            return generatePrice(Integer.parseInt(obj.getQty()), product,product.getUnitsPerCartoon());
        }
    }


    private double getSingleUnitPrice(int units, double cartoonPrice) {
        BigDecimal ctnPrice = new BigDecimal(cartoonPrice);
        ctnPrice.multiply(BigDecimal.valueOf(1.3));
        ctnPrice.divide(BigDecimal.valueOf(units));
        return ctnPrice.doubleValue();
    }
}


