package ru.job4j.bmb.recommendation;

import org.springframework.stereotype.Component;
import ru.job4j.bmb.repository.AchievementRepository;
import ru.job4j.bmb.repository.MoodLogRepository;
import ru.job4j.bmb.repository.UserRepository;

/**
 * @author Maksim Merkulov
 * @version 1.0
 */
@Component
public class MoodContentProvider implements ContentProvider {
    private final UserRepository userRepository;
    private final MoodLogRepository moodLogRepository;
    private final AchievementRepository achievementRepository;

    public MoodContentProvider(UserRepository userRepository,
                               MoodLogRepository moodLogRepository,
                               AchievementRepository achievementRepository) {
        this.userRepository = userRepository;
        this.moodLogRepository = moodLogRepository;
        this.achievementRepository = achievementRepository;
    }
}
