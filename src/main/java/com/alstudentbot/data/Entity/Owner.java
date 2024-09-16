package com.alstudentbot.data.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.UUID;

@jakarta.persistence.Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Owner {
    @Id
    @GeneratedValue
    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private Long ChatId;
    private String step;

}
