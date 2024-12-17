package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner {
    public static void main(String[] args) {
        User user = null;
        MessangeSender messangeSender = new MessangeSender();
        try {
            messangeSender.sendMessageTo(user, "Hello");
        } catch (MessageNotSentException e) {
            System.out.println("Message not sent." + e.getMessage());
        }
        System.out.println("Program finished. Bye!");
    }
}
