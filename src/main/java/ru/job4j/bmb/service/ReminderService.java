package ru.job4j.bmb.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.job4j.bmb.content.Content;
import ru.job4j.bmb.repository.UserRepository;

/**
 * @author Maksim Merkulov
 * @version 1.5
 */
@Service
public class ReminderService implements BeanNameAware {
    private final TelegramBotService telegramBotService;
    private final UserRepository userRepository;

    public ReminderService(TelegramBotService telegramBotService, UserRepository userRepository) {
        this.telegramBotService = telegramBotService;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        System.out.println(
                "ReminderService is going through @PostConstruct init."
        );
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is: " + name);
    }

    @Scheduled(fixedRateString = "${remind.period}")
    public void ping() {
        for (var user : userRepository.findAll()) {
            Content content = new Content(user.getChatId());
            content.setText("Ping");
            telegramBotService.sent(content);
        }
    }

    @PreDestroy
    public void destroy() {
        System.out.println(
                "ReminderService will be destroyed via @PreDestroy."
        );
    }
}
