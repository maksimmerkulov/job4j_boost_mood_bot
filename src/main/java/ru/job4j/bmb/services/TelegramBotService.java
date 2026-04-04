package ru.job4j.bmb.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;
import ru.job4j.bmb.content.Content;

/**
 * @author Maksim Merkulov
 * @version 1.3
 */
@Service
public class TelegramBotService implements BeanNameAware {
    private final BotCommandHandler handler;

    public TelegramBotService(BotCommandHandler handler) {
        this.handler = handler;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is: " + name);
    }

    @PostConstruct
    public void init() {
        System.out.println(
                "TelegramBotService is going through @PostConstruct init."
        );
    }

    public void receive(Content content) {
        handler.receive(content);
    }

    @PreDestroy
    public void destroy() {
        System.out.println(
                "TelegramBotService will be destroyed via @PreDestroy."
        );
    }
}
