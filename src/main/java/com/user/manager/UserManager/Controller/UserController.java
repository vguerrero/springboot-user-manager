package com.user.manager.UserManager.Controller;

import com.user.manager.UserManager.model.User;
import com.user.manager.UserManager.util.ResponseData;
import com.user.manager.UserManager.util.TokenManager;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.user.manager.UserManager.service.UserService;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    TokenManager tokenManager;





    @PostMapping
    public ResponseEntity<?> createUser(HttpServletRequest request, @RequestBody User user) {

        String bearerToken = request.getHeader("Authorization").replace("Bearer ", "");
        ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.OK);
        try {
            if (!userService.validateEmail(user.getEmail())) {
                return new ResponseEntity<>(new ResponseData("el correo no tiene formato correcto" ), HttpStatus.BAD_REQUEST);
            }
            if (userService.getUserByEmail(user.getEmail()) != null) {
                return new ResponseEntity<>(new ResponseData("El correo ya esta registrado" ), HttpStatus.BAD_REQUEST);
            }
            if (tokenManager.validateToken(bearerToken)) {
                return new ResponseEntity<>(userService.createUser(user, bearerToken), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(new ResponseData("token invalido" ), HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseData("Error api usuario: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



    @GetMapping("/all")
    public ResponseEntity<List<User>> getUserById() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }


}
