package ru.job4j.bmb.service;

/**
 * @author Maksim Merkulov
 * @version 1.0
 */
public class SentContentException extends RuntimeException {
    public SentContentException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
