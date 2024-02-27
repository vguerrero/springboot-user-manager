package com.user.manager.UserManager.service;

import com.user.manager.UserManager.util.UserDTO;
import com.user.manager.UserManager.model.User;

import java.util.List;

public interface UserService {

    UserDTO createUser(User user, String token) throws Exception;

    User getUserById(Long userId);

    List<User> getAll();

    User getUserByEmail(String mail);
}
