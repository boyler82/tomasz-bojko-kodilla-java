package com.kodilla.exception.nullpointer;

import java.util.Optional;

public class OptionalException {
    public static void main(String[] args) {
        User user = null;

        Optional<User> optionalUser = Optional.ofNullable(user);

        String username =
                optionalUser.orElse(new User("No name")).getName();
        System.out.println(username);

        Optional<User> optionalUser2 = Optional.ofNullable(user);

        optionalUser2.ifPresent(u -> System.out.println(u.getName()));
    }
}
