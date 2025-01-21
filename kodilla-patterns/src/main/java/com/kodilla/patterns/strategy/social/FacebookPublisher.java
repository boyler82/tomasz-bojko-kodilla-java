package com.kodilla.patterns.strategy.social;

public non-sealed class FacebookPublisher implements SocialPublisher{
    @Override
    public String share() {
        return "I'm using Facebook";
    }
}
