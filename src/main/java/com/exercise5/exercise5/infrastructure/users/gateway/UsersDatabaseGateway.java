package com.exercise5.exercise5.infrastructure.users.gateway;

import com.exercise5.exercise5.common.exception.EmailAlreadyInUseException;
import com.exercise5.exercise5.entity.Users;
import com.exercise5.exercise5.infrastructure.users.mapper.UserRowMapper;
import com.exercise5.exercise5.infrastructure.users.repository.UsersRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDatabaseGateway implements UsersRepository {
    private final JdbcTemplate jdbctemplate;
    private final PasswordEncoder passwordEncoder;

    public UsersDatabaseGateway(final JdbcTemplate jdbctemplate, final PasswordEncoder passwordEncoder){
        this.jdbctemplate = jdbctemplate;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean checkEmail(String email){
        String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
        Integer count = jdbctemplate.queryForObject(sql, Integer.class, email);
        return count > 0;
    }

    @Override
    public void bulkInsert(List<Users> entities) {

    }

    @Override
    public Users save(Users entity) {
        if(checkEmail(entity.getEmail())){
            throw new EmailAlreadyInUseException();
        }

        String sql = "INSERT INTO users (email, password, name) VALUES (?, ?, ?) RETURNING id";
        Long insertedUserId =jdbctemplate.queryForObject(sql, Long.class,
                entity.getEmail(),
                passwordEncoder.encode(entity.getPassword()),
                entity.getName()
        );
        entity.setId(insertedUserId);
        return entity;
    }

    @Override
    public Users findById(Long aLong) {
        return null;
    }

    @Override
    public List<Users> findAll() {
        String sql = "SELECT * FROM users";
        return jdbctemplate.query(sql, new UserRowMapper());
    }

    @Override
    public void delete(Users entity) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Users update(Users entity) {
        return null;
    }
}
