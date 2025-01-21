package com.kodilla.patterns.strategy.social;

public sealed class User permits Millenials, ZGeneration, YGeneration {

    private final String name;
    public SocialPublisher socialPublisher;

    public User(String name) {
        this.name = name;
    }

    public String getSocialPublisher() {
        return socialPublisher.share();
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }

    public String getName() {
        return name;
    }
}
