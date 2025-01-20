package com.kodilla.patterns.enums.hotel;

import java.math.BigDecimal;
import java.util.Map;

public class PriceList {

    private static Map<Season, BigDecimal> singleBedPrice = Map.of(
            Season.LOW, new BigDecimal(100),
            Season.HIGH, new BigDecimal(350),
            Season.HOLIDAY, new BigDecimal(590)
    );

    private static Map<Season, BigDecimal> doubleBedPrice = Map.of(
            Season.LOW, new BigDecimal(200),
            Season.HIGH, new BigDecimal(450),
            Season.HOLIDAY, new BigDecimal(690)
    );

    public static BigDecimal getSingleBedPrice(Season season) {
        return singleBedPrice.get(season);
    }
    public static BigDecimal getDoubleBedPrice(Season season) {
        return doubleBedPrice.get(season);
    }

}
