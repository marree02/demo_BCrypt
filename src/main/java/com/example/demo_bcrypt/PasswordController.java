package com.example.demo_bcrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    @PostMapping("/encrypt")
    public String encryptPassword(@RequestBody String password) {
        return passwordEncoder.encode(password);
    }

    @PostMapping("/verify")
    public boolean verifyPassword(@RequestBody VerifyRequest request) {
        return passwordEncoder.matches(request.getPassword(), request.getHashedPassword());
    }
}
