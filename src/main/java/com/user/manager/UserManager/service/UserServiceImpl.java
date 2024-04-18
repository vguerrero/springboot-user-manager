package com.user.manager.UserManager.service;

import com.user.manager.UserManager.util.UserDTO;
import com.user.manager.UserManager.model.User;
import com.user.manager.UserManager.util.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.user.manager.UserManager.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Value("${regexEmailPattern}")
    private String emailPattern;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepository = userRepo;
    }

    @Override
    public UserDTO createUser(User user, String token) {
        this.setDefaultValues(user, token);
        return mapUserToUserDTO(userRepository.save(user));
    }

    public boolean validateEmail(String email) {
        return Pattern.compile(emailPattern)
                .matcher(email)
                .matches();
    }

    private void setDefaultValues(User user, String token){
        user.setCreated(new Date());
        user.setModified(new Date());
        user.setLast_login(new Date());
        user.setToken(token);
        user.setIsactive(true);
    }

    private UserDTO mapUserToUserDTO(User user) {
        return new UserDTO(String.valueOf(user.getId()), user.getCreated(), user.getModified(), user.getLast_login(), user.getToken(), user.isIsactive());
    }



    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String mail) {
        return this.userRepository.findUserByEmail(mail);
    }
}
