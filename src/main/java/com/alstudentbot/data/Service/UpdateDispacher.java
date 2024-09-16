package com.alstudentbot.data.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.alstudentbot.data.Service.Handler.CallbackQueryHandler;
import com.alstudentbot.data.Service.Handler.CommandHandler;
import com.alstudentbot.data.Service.Handler.MessageHandler;
import com.alstudentbot.data.Telegram.Bot;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class UpdateDispacher {

    final MessageHandler messageHandler;
    final CommandHandler commandHandler;
    final CallbackQueryHandler callbackQueryHandler;

    @Autowired
    public UpdateDispacher(CallbackQueryHandler callbackQueryHandler, CommandHandler commandHandler, MessageHandler messageHandler) {
        this.callbackQueryHandler = callbackQueryHandler;
        this.commandHandler = commandHandler;
        this.messageHandler = messageHandler;
    }

    /**
     * @param update
     * @param bot
     * @return
     */
    public BotApiMethod<?> distribute(Update update , Bot bot){
        if(update.hasCallbackQuery()){
            return callbackQueryHandler.answer(update.getCallbackQuery(),bot);
        }else  if(update.hasMessage()){
            Message message = update.getMessage();
            if(message.hasText()){
                if(message.getText().charAt(0) == '/'){
                    return commandHandler.answer(message,bot);
                }
            }
            try {
                return messageHandler.answer(message,bot);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
        log.info("Undupported update "+update.toString());
        return null;
    }

}
