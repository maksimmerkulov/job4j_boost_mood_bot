package ru.job4j.bot;

import ru.job4j.service.MoodService;

/**
 * @author Maksim Merkulov
 * @version 1.0
 */
public class BotCommandHandler {
    private final MoodService moodService;

    public BotCommandHandler(MoodService moodService) {
        this.moodService = moodService;
    }
}
