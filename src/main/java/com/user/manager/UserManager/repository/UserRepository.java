package com.user.manager.UserManager.repository;

import com.user.manager.UserManager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {

    User findUserByEmail(String email);
}
