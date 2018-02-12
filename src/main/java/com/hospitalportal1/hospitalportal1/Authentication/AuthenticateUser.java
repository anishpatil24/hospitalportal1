package com.hospitalportal1.hospitalportal1.Authentication;

import com.hospitalportal1.hospitalportal1.Entity.Login;
import com.hospitalportal1.hospitalportal1.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AuthenticateUser {

    @Autowired
    LoginRepository loginRepository;

    public Boolean validateUser(String username, String password) {
        Login user = loginRepository.findByUserName(username);
        if (password.equals(user.getPassword()))
            return true;
        return null;
    }
}
