package com.kodilla.patterns.strategy.social;

public non-sealed class TwitterPublisher implements SocialPublisher{
    @Override
    public String share() {
        return "I'm using Twitter";
    }
}
