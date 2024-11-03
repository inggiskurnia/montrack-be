package com.exercise5.exercise5.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private long id;
    private String email;
    private String password;
    private String name;
    private int pin;
    private String profilePictureUrl;
    private String quotes;
    private boolean isOnboardingComplete;
    private boolean isActive;
    private ZonedDateTime lastLoginAt;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private ZonedDateTime deletedAt;
}
