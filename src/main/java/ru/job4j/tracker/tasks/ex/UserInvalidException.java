package ru.job4j.tracker.tasks.ex;

public class UserInvalidException extends UserNotFoundException {
    public UserInvalidException(String message) {
        super(message);
    }
}
