package com.exercise.demo.model;

/**
 * Created By DeshanW
 *
 * CalculatedPriceRequestObject
 **/

public class CalculatedPriceRequestObject {

    private String qty;
    private String product;

    private boolean qtyType;

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String produuct) {
        this.product = produuct;
    }

    public boolean isQtyType() {
        return qtyType;
    }

    public void setQtyType(boolean qtyType) {
        this.qtyType = qtyType;
    }


}
