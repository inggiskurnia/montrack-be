package com.exercise5.exercise5.usecase.user;

import com.exercise5.exercise5.entity.Users;

public interface LoginUserUseCase {
    Users loginUser(String email, String password);
}
