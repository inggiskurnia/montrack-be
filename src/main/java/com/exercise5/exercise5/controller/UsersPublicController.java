package com.exercise5.exercise5.controller;

import com.exercise5.exercise5.common.exception.EmailAlreadyInUseException;
import com.exercise5.exercise5.common.response.ApiResponse;
import com.exercise5.exercise5.infrastructure.users.dto.CreateUserDTO;
import com.exercise5.exercise5.infrastructure.users.gateway.UsersDatabaseGateway;
import com.exercise5.exercise5.usecase.user.CreateUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UsersPublicController {
    private final CreateUserUseCase createUserUseCase;

    public UsersPublicController(CreateUserUseCase createUserUseCase){
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserDTO req){
        try{
            return ApiResponse.successfulResponse("Create new user success", createUserUseCase.createUser(req));
        } catch (EmailAlreadyInUseException e){
            return  ApiResponse.failedResponse(409, e.getMessage());
        }

    }

}
