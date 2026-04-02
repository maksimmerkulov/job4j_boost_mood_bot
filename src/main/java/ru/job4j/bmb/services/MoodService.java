package ru.job4j.bmb.services;

import ru.job4j.bmb.recommendations.RecommendationEngine;

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
