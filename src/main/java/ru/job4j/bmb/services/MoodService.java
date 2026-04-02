package ru.job4j.bmb.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import ru.job4j.bmb.recommendations.RecommendationEngine;

/**
 * @author Maksim Merkulov
 * @version 1.1
 */
public class MoodService {
    private final RecommendationEngine recommendationEngine;

    public MoodService(RecommendationEngine engine) {
        this.recommendationEngine = engine;
    }

    @PostConstruct
    public void init() {
        System.out.println(
                "MoodService is going through @PostConstruct init."
        );
    }

    @PreDestroy
    public void destroy() {
        System.out.println(
                "MoodService will be destroyed via @PreDestroy."
        );
    }
}
