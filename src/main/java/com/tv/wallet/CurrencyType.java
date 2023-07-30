package com.tv.wallet;

public enum CurrencyType {
    BTH(1),
    INR(2 * BTH.conversionFactor),
    USD(80 * INR.conversionFactor),
    GBP(160 * INR.conversionFactor);

    private final int conversionFactor;

    CurrencyType(int conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    double convertFrom(double tmpValue, CurrencyType other) {
        double baseValue = other.toBase(tmpValue);
        return fromBase(baseValue);
    }

    private double fromBase(double value) {
        return value / this.conversionFactor;
    }

    private double toBase(double value) {
        return value * this.conversionFactor;
    }

}
