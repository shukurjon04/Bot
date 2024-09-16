package com.alstudentbot.data.Service.Handler;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;

import com.alstudentbot.data.Telegram.Bot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class MessageHandler {

    public BotApiMethod<?> answer(Message message,Bot bot) throws TelegramApiException {
        if (message.hasText()) {
            return SendMessage.builder()
                    .chatId(message.getChatId())
                    .text(message.getText())
                    .build();
        } else if (message.hasPhoto()) {
            return bot.execute(SendPhoto.builder()
                            .chatId(message.getChatId())
                            .photo(new InputFile(String.valueOf(message.getPhoto())))
                    .build());
        }
    }

}
