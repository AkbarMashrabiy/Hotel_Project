package org.example.entity;

import lombok.*;
import org.example.enums.UserType;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private double balance;
    private UserType type;

}
