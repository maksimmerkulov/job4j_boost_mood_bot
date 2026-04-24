package ru.job4j.bmb.service;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.bmb.content.Content;
import ru.job4j.bmb.model.User;
import ru.job4j.bmb.model.UserEvent;
import ru.job4j.bmb.repository.AchievementRepository;
import ru.job4j.bmb.repository.MoodLogRepository;

/**
 * @author Maksim Merkulovщ
 * @version 1.3
 */
@Service
public class AchievementService implements ApplicationListener<UserEvent> {
    private final SentContent client;
    private final MoodLogRepository moodLogRepository;
    private final AchievementRepository achievementRepository;

    public AchievementService(SentContent client,
                              MoodLogRepository moodLogRepository,
                              AchievementRepository achievementRepository) {
        this.client = client;
        this.moodLogRepository = moodLogRepository;
        this.achievementRepository = achievementRepository;
    }

    @Transactional
    @Override
    public void onApplicationEvent(UserEvent event) {
        User user = event.getUser();
        long count = moodLogRepository.findAll().stream()
                .filter(log -> log.getUser().getId().equals(user.getId()))
                .count();
        if (count == 1) {
            Content content = new Content(user.getChatId());
            content.setText("🏆 Поздравляем! Вы получили достижение: "
                    + "'Первый шаг к позитиву'!");
            client.sent(content);
        }
    }
}
