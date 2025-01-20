package com.kodilla.patterns.strategy.predictors;

import com.kodilla.patterns.strategy.BuyPredictor;

import java.util.stream.BaseStream;

public class BalancedPredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[BALANCED PREDICTOR]";
    }
}
