package ru.job4j.bmb.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.job4j.bmb.repository.UserRepository;

/**
 * @author Maksim Merkulov
 * @version 1.4
 */
@Service
public class ReminderService implements BeanNameAware {
    private final TgRemoteService tgRemoteService;
    private final UserRepository userRepository;

    public ReminderService(TgRemoteService tgRemoteService, UserRepository userRepository) {
        this.tgRemoteService = tgRemoteService;
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
            var message = new SendMessage();
            message.setChatId(user.getChatId());
            message.setText("Ping");
            tgRemoteService.send(message);
        }
    }

    @PreDestroy
    public void destroy() {
        System.out.println(
                "ReminderService will be destroyed via @PreDestroy."
        );
    }
}
