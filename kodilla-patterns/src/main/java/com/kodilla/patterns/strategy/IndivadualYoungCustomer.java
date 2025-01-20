package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.predictors.ConservativePredictor;

public class IndivadualYoungCustomer extends Customer{


    public IndivadualYoungCustomer(String name) {
        super(name);
        this.buyPredictor = new ConservativePredictor();

    }
}
