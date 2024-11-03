package com.exercise5.exercise5.usecase.user.impl;

import com.exercise5.exercise5.entity.Users;
import com.exercise5.exercise5.infrastructure.users.gateway.UsersDatabaseGateway;
import com.exercise5.exercise5.usecase.user.LoginUserUseCase;
import org.springframework.stereotype.Service;

@Service
public class LoginUserUseCaseImp implements LoginUserUseCase {
    private UsersDatabaseGateway usersDatabaseGateway;

    public LoginUserUseCaseImp(UsersDatabaseGateway usersDatabaseGateway){
        this.usersDatabaseGateway = usersDatabaseGateway;
    }

    @Override
    public Users loginUser(String email, String password) {

        return null;
    }
}
