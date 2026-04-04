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
public class BotCommandHandler implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is: " + name);
    }

    @PostConstruct
    public void init() {
        System.out.println(
                "BotCommandHandler is going through @PostConstruct init."
        );
    }

    void receive(Content content) {
        System.out.println(content);
    }

    @PreDestroy
    public void destroy() {
        System.out.println(
                "BotCommandHandler will be destroyed via @PreDestroy."
        );
    }
}
