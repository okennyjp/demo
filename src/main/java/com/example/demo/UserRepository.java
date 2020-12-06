package com.example.demo;

import java.util.List;

public interface UserRepository {
    List<User> findByLoginId(String login_id);
    void save(User user);
}
