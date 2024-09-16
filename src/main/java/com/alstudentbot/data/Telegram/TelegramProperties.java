package com.alstudentbot.data.Telegram;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix="telegram-bot")
@FieldDefaults(level=AccessLevel.PRIVATE)
public class TelegramProperties {
    String username;
    String token;
    String path;

}
