package com.user.manager.UserManager.Controller;

import com.user.manager.UserManager.util.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    TokenManager tokenManager;

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String user) {
        String token = tokenManager.generateToken(user);
        return ResponseEntity.ok(token);
    }
}
