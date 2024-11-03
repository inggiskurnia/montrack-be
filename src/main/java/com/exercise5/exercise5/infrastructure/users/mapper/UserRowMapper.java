package com.exercise5.exercise5.infrastructure.users.mapper;

import com.exercise5.exercise5.entity.Users;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class UserRowMapper implements RowMapper<Users> {

    public static ZonedDateTime convertToZonedDateTime(Date date) {
        if(date != null){
            return ZonedDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        }
        return null;
    }

    @Override
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
        Users user = new Users();
        user.setId(rs.getLong("id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setPin(rs.getInt("pin"));
        user.setProfilePictureUrl(rs.getString("profile_picture_url"));
        user.setQuotes(rs.getString("quotes"));
        user.setOnboardingComplete(rs.getBoolean("is_onboarding_complete"));
        user.setActive(rs.getBoolean("is_active"));
        user.setCreatedAt(convertToZonedDateTime(rs.getDate("created_at")));
        user.setUpdatedAt(convertToZonedDateTime(rs.getDate("updated_at")));
        user.setDeletedAt(convertToZonedDateTime(rs.getDate("deleted_at")));
        return user;
    }
}
