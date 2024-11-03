package com.exercise5.exercise5.usecase.user.impl;

import com.exercise5.exercise5.entity.Users;
import com.exercise5.exercise5.infrastructure.users.gateway.UsersDatabaseGateway;
import com.exercise5.exercise5.usecase.user.GetUsersUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUsersUseCaseImp implements GetUsersUseCase {
    private UsersDatabaseGateway usersDatabaseGateway;

    public GetUsersUseCaseImp(UsersDatabaseGateway usersDatabaseGateway){
        this.usersDatabaseGateway = usersDatabaseGateway;
    }

    @Override
    public List<Users> getAllUsers() {
        return usersDatabaseGateway.findAll();
    }
}
