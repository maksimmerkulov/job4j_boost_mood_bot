package ru.job4j.bmb.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;

/**
 * @author Maksim Merkulov
 * @version 1.3
 */
@Service
public class MoodService implements BeanNameAware {
    private final RecommendationEngine recommendationEngine;

    public MoodService(RecommendationEngine engine) {
        this.recommendationEngine = engine;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is: " + name);
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
