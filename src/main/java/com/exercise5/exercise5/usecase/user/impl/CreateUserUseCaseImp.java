package com.exercise5.exercise5.usecase.user.impl;

import com.exercise5.exercise5.entity.Users;
import com.exercise5.exercise5.infrastructure.users.dto.CreateUserDTO;
import com.exercise5.exercise5.infrastructure.users.gateway.UsersDatabaseGateway;
import com.exercise5.exercise5.usecase.user.CreateUserUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCaseImp implements CreateUserUseCase {
    private final UsersDatabaseGateway usersDatabaseGateway;

    public CreateUserUseCaseImp(UsersDatabaseGateway usersDatabaseGateway){
        this.usersDatabaseGateway = usersDatabaseGateway;
    }

    @Override
    public Users createUser(CreateUserDTO req) {
        return usersDatabaseGateway.save(req.toEntity());
    }
}
