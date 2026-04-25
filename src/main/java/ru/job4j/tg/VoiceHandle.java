package ru.job4j.tg;

import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @author Maksim Merkulov
 * @version 1.0
 */
public class VoiceHandle {
    public void process(String message, Consumer<String> handler) {
        IntStream.range(0, 5).forEach(it -> {
            try {
                Thread.sleep(1000);
                handler.accept(String.format("Message: %s", message, it));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
