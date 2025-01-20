package com.kodilla.patterns.strategy.predictors;

import com.kodilla.patterns.strategy.BuyPredictor;

public class ConservativePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[CONSERVATIVE PREDICTOR]";
    }
}
