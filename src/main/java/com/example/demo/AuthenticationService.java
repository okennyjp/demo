package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AuthenticationService {
    private UserRepository userRepository;

    @Autowired
    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean signin(String login_id, String password) {
        User user = new User();
        user.setLoginId(login_id);
        user.setPassword(password);
        user.setName(login_id);
        try{
          getUserRepository().save(user);
        }catch(Exception e){
          return false;
        }
        return true;
    }

    public boolean signon(String login_id, String password) {
        boolean return_value = false;
        List<User> users = getUserRepository().findByLoginId(login_id);
        for(User user : users) return_value =  user.authenticate(password);
        return return_value;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

}
