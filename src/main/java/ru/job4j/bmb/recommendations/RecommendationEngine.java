package ru.job4j.bmb.recommendations;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
 * @author Maksim Merkulov
 * @version 1.1
 */
public class RecommendationEngine {
    private final ContentProvider contentProvider;

    public RecommendationEngine(ContentProvider contentProvider) {
        this.contentProvider = contentProvider;
    }

    @PostConstruct
    public void init() {
        System.out.println(
                "RecommendationEngine is going through @PostConstruct init."
        );
    }

    @PreDestroy
    public void destroy() {
        System.out.println(
                "RecommendationEngine will be destroyed via @PreDestroy."
        );
    }
}
