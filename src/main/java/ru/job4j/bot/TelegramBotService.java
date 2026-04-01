package ru.job4j.bot;

/**
 * @author Maksim Merkulov
 * @version 1.0
 */
public class TelegramBotService {
    private final BotCommandHandler commandHandler;

    public TelegramBotService(BotCommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }
}
