package ru.job4j.service;

import ru.job4j.recommendation.RecommendationEngine;

/**
 * @author Maksim Merkulov
 * @version 1.0
 */
public class MoodService {
    private final RecommendationEngine recommendationEngine;

    public MoodService(RecommendationEngine engine) {
        this.recommendationEngine = engine;
    }
}
