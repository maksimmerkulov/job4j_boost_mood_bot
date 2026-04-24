package ru.job4j.bmb.service;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.job4j.bmb.config.OnFakeModeCondition;
import ru.job4j.bmb.content.Content;

/**
 * @author Maksim Merkulov
 * @version 1.0
 */
@Service
@Conditional(OnFakeModeCondition.class)
public class FakeTelegramBotService
        extends TelegramLongPollingBot
        implements SentContent {

    public FakeTelegramBotService() {
        super("");
    }

    @Override
    public void sent(Content content) {
        System.out.println("[FAKE BOT LOG]");
        System.out.println("Получатель (chatId): " + content.getChatId());
        System.out.println("Текст сообщения: " + content.getText());
        System.out.println("-------------------------");
    }

    @Override
    public void onUpdateReceived(Update update) {
    }

    @Override
    public String getBotUsername() {
        return "fake_bot";
    }

    @Override
    public String getBotToken() {
        return "";
    }
}
