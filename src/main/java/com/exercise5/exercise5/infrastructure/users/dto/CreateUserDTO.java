package com.exercise5.exercise5.infrastructure.users.dto;

import com.exercise5.exercise5.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {
    private String name;
    private String email;
    private String password;

    public Users toEntity () {
        Users users = new Users();
        users.setName(name);
        users.setEmail(email);
        users.setPassword(password);
        return users;
    }


}
