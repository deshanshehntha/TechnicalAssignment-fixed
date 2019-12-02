package com.exercise.demo.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public final class Constants {

    public static final String GET_HORSESHOE_PRICE_LIST = "21";
    public static final String GET_PENGUIN_PRICE_LIST = "22";
    public static final String GET_PRODUCT_DATA = "23";
    public static final String GET_CALCULATED_PRICE = "24";

    public static final String HORESESHOE = "Horseshoe";
    public static final String PENGUINEARS = "PenguinEars";

    public static double twoDecimalFormatter(Double number) {
        NumberFormat formatter = new DecimalFormat("#0.00");
        return Double.parseDouble(formatter.format(number));
    }
}
