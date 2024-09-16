package com.alstudentbot.data.Service.Handler;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import com.alstudentbot.data.Telegram.Bot;

@Service
public class CommandHandler {

    public BotApiMethod<?> answer(Message message,Bot bot){
        return null;
    }

}
