package ru.job4j.bmb.services;

import org.springframework.stereotype.Service;
import ru.job4j.bmb.content.Content;

/**
 * @author Maksim Merkulov
 * @version 1.1
 */
@Service
public class BotCommandHandler {
    void receive(Content content) {
        System.out.println(content);
    }
}
