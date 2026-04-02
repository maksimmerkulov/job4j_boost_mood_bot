package ru.job4j.bmb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Maksim Merkulov
 * @version 1.0
 */
@Component
public class AppConfig {
    @Value("${telegram.bot.name}")
    private String botName;
}
