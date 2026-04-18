package ru.job4j.bmb.service;

import org.springframework.stereotype.Service;
import ru.job4j.bmb.content.Content;
import ru.job4j.bmb.model.MoodLog;
import ru.job4j.bmb.model.User;
import ru.job4j.bmb.repository.AchievementRepository;
import ru.job4j.bmb.repository.MoodLogRepository;
import ru.job4j.bmb.repository.UserRepository;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

/**
 * @author Maksim Merkulov
 * @version 1.5
 */
@Service
public class MoodService {
    private final MoodLogRepository moodLogRepository;
    private final RecommendationEngine recommendationEngine;
    private final UserRepository userRepository;
    private final AchievementRepository achievementRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("dd-MM-yyyy HH:mm")
            .withZone(ZoneId.systemDefault());

    public MoodService(MoodLogRepository moodLogRepository,
                       RecommendationEngine recommendationEngine,
                       UserRepository userRepository,
                       AchievementRepository achievementRepository) {
        this.moodLogRepository = moodLogRepository;
        this.recommendationEngine = recommendationEngine;
        this.userRepository = userRepository;
        this.achievementRepository = achievementRepository;
    }

    public Content chooseMood(User user, Long moodId) {
        return recommendationEngine.recommendFor(user.getChatId(), moodId);
    }

    public Optional<Content> weekMoodLogCommand(long chatId, Long clientId) {
        long weekAgo = Instant.now().minus(7, ChronoUnit.DAYS).getEpochSecond();
        return getMoodLogReport(chatId, clientId, weekAgo, "Weekly mood log");
    }

    public Optional<Content> monthMoodLogCommand(long chatId, Long clientId) {
        long monthAgo = Instant.now().minus(30, ChronoUnit.DAYS).getEpochSecond();
        return getMoodLogReport(chatId, clientId, monthAgo, "Monthly mood log");
    }

    public Optional<Content> awards(long chatId, Long clientId) {
        return userRepository.findByClientId(clientId).map(user -> {
            var achievements = achievementRepository.findAll().stream()
                    .filter(a -> a.getUser().getId().equals(user.getId()))
                    .toList();
            var sb = new StringBuilder("\uD83C\uDFC6 Your awards:\n");
            if (achievements.isEmpty()) {
                sb.append("You have no awards yet. Keep sharing your mood!");
            } else {
                achievements.forEach(a -> sb.append("- ")
                        .append(a.getAward().getTitle())
                        .append(": ")
                        .append(a.getAward().getDescription())
                        .append("\n"));
            }
            var content = new Content(chatId);
            content.setText(sb.toString());
            return content;
        });
    }

    private Optional<Content> getMoodLogReport(
            long chatId,
            Long clientId,
            long startPeriod,
            String title
    ) {
        return userRepository.findByClientId(clientId).map(user -> {
            List<MoodLog> logs = moodLogRepository.findAll().stream()
                    .filter(l -> l.getUser().getId().equals(user.getId())
                            && l.getCreatedAt() >= startPeriod)
                    .toList();
            var content = new Content(chatId);
            content.setText(formatMoodLogs(logs, title));
            return content;
        });
    }

    private String formatMoodLogs(List<MoodLog> logs, String title) {
        if (logs.isEmpty()) {
            return title + ":\nNo mood logs found.";
        }
        var sb = new StringBuilder(title + ":\n");
        logs.forEach(log -> {
            String formattedDate = formatter.format(
                    Instant.ofEpochSecond(log.getCreatedAt())
            );
            sb.append(formattedDate)
                    .append(": ")
                    .append(log.getMood().getText())
                    .append("\n");
        });
        return sb.toString();
    }
}
