package com.kodilla.patterns.enums.hotel;

import java.math.BigDecimal;

public enum Season {
    LOW(new BigDecimal(100), new BigDecimal (150)),
    HIGH(new BigDecimal(200), new BigDecimal (250)),
    HOLIDAY(new BigDecimal(400), new BigDecimal (450));

    private BigDecimal singleBedPrice;
    private BigDecimal doubleBedPrice;

    Season(BigDecimal doubleBedPrice, BigDecimal singleBedPrice) {
        this.doubleBedPrice = doubleBedPrice;
        this.singleBedPrice = singleBedPrice;
    }

    public BigDecimal getDoubleBedPrice() {
        return doubleBedPrice;
    }

    public BigDecimal getSingleBedPrice() {
        return singleBedPrice;
    }
}
