package com.example.demo_bcrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    @PostMapping("/login")
    public String login(@RequestBody VerifyRequest request) {
        String storedPasswordHash = "$2a$10$xgtu.jqpvRMZEeMzFpNrLe8qgVBDClkdV3s1xDYfsVwIOJhyNBiTm";
        System.out.println("Stored Password Hash: " + storedPasswordHash);
        System.out.println("Received Password: " + request.getPassword());

        if (passwordEncoder.matches(request.getPassword(), storedPasswordHash)) {
            return "Login successful!";
        } else {
            return "Login failed!";
        }
    }
}


