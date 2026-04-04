package ru.job4j.bmb.recommendation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

/**
 * @author Maksim Merkulov
 * @version 1.1
 */
@Component
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
