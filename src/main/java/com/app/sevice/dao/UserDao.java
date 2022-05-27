package com.app.sevice.dao;

import com.app.domain.Author;
import com.app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    // SELECT * FROM author WHERE name = ?
    User findByName(String name);
    User getByNameAndPassword(String nameUser,String password);
}
