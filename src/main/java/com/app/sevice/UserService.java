package com.app.sevice;

import com.app.domain.User;

import java.util.List;

public interface UserService {

    User insert(User user);

    User update(int id, String newNameUser);

    List<User> getAll();

    User getById(int id);

    User getByName(String nameUser);
    User getByNameAndPassword(String nameUser,String password);

    void deleteById(int id);
}
