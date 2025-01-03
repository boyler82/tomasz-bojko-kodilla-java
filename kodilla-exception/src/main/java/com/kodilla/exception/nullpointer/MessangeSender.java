package com.kodilla.exception.nullpointer;

public class MessangeSender {

    public void sendMessageTo(User user, String message) throws MessageNotSentException {
        if (user != null) {
            System.out.println("Sending message: '" + message + "' to: " + user.getName());
        } else {
            throw new MessageNotSentException("User is null");
        }
    }
}
