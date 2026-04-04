package ru.job4j.bmb.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;
import ru.job4j.bmb.repository.AchievementRepository;
import ru.job4j.bmb.repository.MoodLogRepository;
import ru.job4j.bmb.repository.UserRepository;

/**
 * @author Maksim Merkulov
 * @version 1.2
 */
@Service
public class AchievementService implements BeanNameAware {
    private final TelegramBotService telegramBotService;
    private final UserRepository userRepository;
    private final MoodLogRepository moodLogRepository;
    private final AchievementRepository achievementRepository;

    public AchievementService(TelegramBotService telegramBotService,
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
                "AchievementService is going through @PostConstruct init."
        );
    }

    @PreDestroy
    public void destroy() {
        System.out.println(
                "AchievementService will be destroyed via @PreDestroy."
        );
    }
}
