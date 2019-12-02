package com.exercise.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * Created By DeshanW
 *
 * Model Class for Products
 *
 * Penguin-ears &
 * Horseshoe
 **/

@Document(collection = "product")
public class Product {

    @Id
    private String _id;
    private String productName;
    private int unitsPerCartoon;
    private double pricePerCartoon;
    private double  singleUnitPrice;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getUnitsPerCartoon() {
        return unitsPerCartoon;
    }

    public void setUnitsPerCartoon(int unitsPerCartoon) {
        this.unitsPerCartoon = unitsPerCartoon;
    }

    public double getPricePerCartoon() {
        return pricePerCartoon;
    }

    public void setPricePerCartoon(double pricePerCartoon) {
        this.pricePerCartoon = pricePerCartoon;
    }

    public double getSingleUnitPrice() {
        return singleUnitPrice;
    }

    public void setSingleUnitPrice(double singleUnitPrice) {
        this.singleUnitPrice = singleUnitPrice;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }


}
