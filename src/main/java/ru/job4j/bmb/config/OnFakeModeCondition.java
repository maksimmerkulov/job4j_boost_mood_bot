package ru.job4j.bmb.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Maksim Merkulov
 * @version 1.0
 */
public class OnFakeModeCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return "fake".equals(context.getEnvironment().getProperty("telegram.mode"));
    }
}
