package ru.job4j.recommendation;

/**
 * @author Maksim Merkulov
 * @version 1.0
 */
public class RecommendationEngine {
    private final ContentProvider contentProvider;

    public RecommendationEngine(ContentProvider contentProvider) {
        this.contentProvider = contentProvider;
    }
}
