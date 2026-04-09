package ru.job4j.bmb.content;

/**
 * @author Maksim Merkulov
 * @version 1.0
 */
public interface ContentProvider {
    Content byMood(Long chatId, Long moodId);
}
