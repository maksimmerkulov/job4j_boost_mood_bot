package ru.job4j.bmb.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;
import ru.job4j.bmb.repositories.AchievementRepository;
import ru.job4j.bmb.repositories.MoodLogRepository;
import ru.job4j.bmb.repositories.UserRepository;

/**
 * @author Maksim Merkulov
 * @version 1.2
 */
@Service
public class ReminderService implements BeanNameAware {
    private final TelegramBotService telegramBotService;
    private final UserRepository userRepository;
    private final MoodLogRepository moodLogRepository;
    private final AchievementRepository achievementRepository;

    public ReminderService(TelegramBotService telegramBotService,
                           UserRepository userRepository,
                           MoodLogRepository moodLogRepository,
                           AchievementRepository achievementRepository) {
        this.telegramBotService = telegramBotService;
        this.userRepository = userRepository;
        this.moodLogRepository = moodLogRepository;
        this.achievementRepository = achievementRepository;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is: " + name);
    }

    @PostConstruct
    public void init() {
        System.out.println(
                "ReminderService is going through @PostConstruct init."
        );
    }

    @PreDestroy
    public void destroy() {
        System.out.println(
                "ReminderService will be destroyed via @PreDestroy."
        );
    }
}
