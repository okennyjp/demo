package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcUserRepository implements UserRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        getJdbcTemplate().update(
            "INSERT INTO users (id, login_id, password, user_name) VALUES (DEFAULT, ?, ?, ?)",
            user.getLoginId(), user.getPassword(), user.getName());
    }

    @Override
    public List<User> findByLoginId(String login_id) {
        return getJdbcTemplate().query(
            "SELECT login_id, password FROM users WHERE login_id = ?", (resultSet, i) -> {
                User user = new User();
                user.setLoginId(resultSet.getString("login_id"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }, login_id);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
