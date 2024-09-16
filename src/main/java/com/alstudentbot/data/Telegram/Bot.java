package com.alstudentbot.data.Telegram;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.alstudentbot.data.Service.UpdateDispacher;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
@Component
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Bot extends TelegramWebhookBot {

    final TelegramProperties telegramProperties;
    final UpdateDispacher dispacher;

    public Bot(TelegramProperties telegramProperties,UpdateDispacher dispacher) {
        this.telegramProperties = telegramProperties;
        this.dispacher = dispacher;
    }

    @Override
    public String getBotPath() {
       return telegramProperties.getPath();
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update arg0) {
        return dispacher.distribute(arg0, this);
    }

    @Override
    public String getBotToken() {
       return telegramProperties.getToken();
    }

    @Override
    public String getBotUsername() {
        return telegramProperties.getUsername();
    }

}
