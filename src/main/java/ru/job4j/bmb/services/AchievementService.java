package ru.job4j.bmb.services;

import ru.job4j.bmb.repositories.AchievementRepository;
import ru.job4j.bmb.repositories.MoodLogRepository;
import ru.job4j.bmb.repositories.UserRepository;

/**
 * @author Maksim Merkulov
 * @version 1.0
 */
public class AchievementService {
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
}
