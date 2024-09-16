package com.alstudentbot.data.Service.Handler;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import com.alstudentbot.data.Telegram.Bot;

@Service
public class CallbackQueryHandler {
 
    public BotApiMethod<?> answer(CallbackQuery callbackQuery,Bot bot){
        return null;
    }
}
