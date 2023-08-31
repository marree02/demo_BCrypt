package com.example.demo_bcrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    @PostMapping("/login")
    public String login(@RequestBody String password) {
        String storedPassword = "$2a$10$2cVpMntbODRzm1mg4XhF.O86U.iU18MtvpdfABV.mgMqrmLrJ0BLm";
        System.out.println("Stored Password: " + storedPassword);
        System.out.println("Received Password: " + password);

        if (passwordEncoder.matches(password, storedPassword)) {
            return "Login successful!";
        } else {
            return "Login failed!";
        }
    }
}
