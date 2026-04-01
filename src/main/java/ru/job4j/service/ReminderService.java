package ru.job4j.service;

import ru.job4j.bot.TelegramBotService;
import ru.job4j.repository.AchievementRepository;
import ru.job4j.repository.MoodLogRepository;
import ru.job4j.repository.UserRepository;

/**
 * @author Maksim Merkulov
 * @version 1.0
 */
public class ReminderService {
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
}
