package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.predictors.BalancedPredictor;

public class IndividualCustomer extends Customer{
    public IndividualCustomer(String name) {
        super(name);
        this.buyPredictor = new BalancedPredictor();
    }
}
