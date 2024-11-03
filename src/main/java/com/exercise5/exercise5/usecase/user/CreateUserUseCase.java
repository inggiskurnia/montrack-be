package com.exercise5.exercise5.usecase.user;

import com.exercise5.exercise5.entity.Users;
import com.exercise5.exercise5.infrastructure.users.dto.CreateUserDTO;

public interface CreateUserUseCase {
    Users createUser(CreateUserDTO req);
}

