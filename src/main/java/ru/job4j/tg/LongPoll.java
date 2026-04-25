package ru.job4j.tg;

/**
 * @author Maksim Merkulov
 * @version 1.0
 */
public abstract class LongPoll {
    abstract void receive(String message);

    public final void sent(String message) {
        System.out.println(message);
    }
}
