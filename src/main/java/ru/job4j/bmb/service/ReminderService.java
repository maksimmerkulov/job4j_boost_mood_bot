package ru.job4j.bmb.service;

import org.springframework.stereotype.Service;
import ru.job4j.bmb.repository.AchievementRepository;
import ru.job4j.bmb.repository.MoodLogRepository;
import ru.job4j.bmb.repository.UserRepository;

/**
 * @author Maksim Merkulov
 * @version 1.3
 */
@Service
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
