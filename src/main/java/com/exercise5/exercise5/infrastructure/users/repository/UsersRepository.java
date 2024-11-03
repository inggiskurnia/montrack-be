package com.exercise5.exercise5.infrastructure.users.repository;

import com.exercise5.exercise5.entity.Users;
import com.exercise5.exercise5.repository.GenericRepository;

import java.util.List;

public interface UsersRepository extends GenericRepository<Users, Long> {
    public void bulkInsert(List<Users> entities);
}
