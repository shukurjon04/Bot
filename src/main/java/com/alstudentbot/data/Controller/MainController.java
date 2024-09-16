package com.alstudentbot.data.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.alstudentbot.data.Telegram.Bot;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@RestController
@FieldDefaults(level=AccessLevel.PRIVATE)
public class MainController {

    final Bot bot;

    @Autowired
    public MainController(Bot bot) {
        this.bot = bot;
    }


    @PostMapping("/")
    public BotApiMethod<?> lister(@RequestBody Update update){
         return bot.onWebhookUpdateReceived(update);
    }
    /*private BotApiMethod<?> echo(Message message){
        if(message.hasText()){
            if ("/create_bot".equals(message.getText())){
                return SendMessage.builder().chatId(message.getChatId()).text("Yangi bot yaratish uchun bot nomi va token yuboring.").build();
            }
            if (message.getText().startsWith("bot_name")) {
                String botName = message.getText().replace("bot_name ", "");
                createNewBotForUser(botName);
            }
            if (message.getText().startsWith("bot_token")) {
                String botName = message.getText().replace("bot_token ", "");
                createNewBotForUser(botName);
            }
            return  SendMessage.builder()
                    .chatId(message.getChatId())
                    .text(String.format("Hello, <a href=\"tg://user?id=%d\">%s</a>! You said: %s",
                            message.getFrom().getId(),
                            message.getFrom().getFirstName() + " " + message.getFrom().getLastName(),
                            message.getText()))
                    .parseMode(ParseMode.HTML)
                    .build();
        }
        return SendMessage.builder()
                .chatId(message.getChatId())
                .text("notori habar")
                .build();


    }

    private void createNewBotForUser(String botName) {
        // Yangi bot uchun webhook o'rnatish
        String webhookUrl = "https://4b5d-37-110-210-124.ngrok-free.app" + botName;

    }
    public void setWebhookForBot(String botToken, String webhookUrl) {
        String url = "https://api.telegram.org/bot" + botToken + "/setWebhook?url=" + webhookUrl;
        // URL ga so'rov yuborib webhook o'rnatish
        // HTTP client yordamida o'rnatish
    }*/

}
