package com.hospitalportal1.hospitalportal1.controller;

import com.hospitalportal1.hospitalportal1.model.JwtUser;
import com.hospitalportal1.hospitalportal1.security.JwtGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/token")
public class TokenController {

    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }
    @PostMapping
    public String generate(@RequestBody JwtUser jwtUser) {

        return jwtGenerator.generate(jwtUser);

    }

}

