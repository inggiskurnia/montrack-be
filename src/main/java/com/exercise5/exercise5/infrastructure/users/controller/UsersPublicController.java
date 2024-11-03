package com.exercise5.exercise5.infrastructure.users.controller;

import com.exercise5.exercise5.common.exception.EmailAlreadyInUseException;
import com.exercise5.exercise5.common.response.ApiResponse;
import com.exercise5.exercise5.infrastructure.users.dto.CreateUserDTO;
import com.exercise5.exercise5.usecase.user.CreateUserUseCase;
import com.exercise5.exercise5.usecase.user.GetUsersUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UsersPublicController {
    private final CreateUserUseCase createUserUseCase;
    private final GetUsersUseCase getUsersUseCase;

    public UsersPublicController(CreateUserUseCase createUserUseCase, GetUsersUseCase getUsersUseCase){
        this.createUserUseCase = createUserUseCase;
        this.getUsersUseCase = getUsersUseCase;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ApiResponse.successfulResponse(HttpStatus.OK.value(), "Get all user success", getUsersUseCase.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserDTO req){
        try{
            return ApiResponse.successfulResponse("Create new user success", createUserUseCase.createUser(req));
        } catch (EmailAlreadyInUseException e){
            return  ApiResponse.failedResponse(HttpStatus.CONFLICT.value(), e.getMessage());
        }

    }

}
