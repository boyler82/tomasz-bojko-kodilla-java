package com.kodilla.patterns.strategy.social;

public non-sealed class SnapchatPublisher implements SocialPublisher{
    @Override
    public String share() {
        return "I'm using Snapchat";
    }
}
