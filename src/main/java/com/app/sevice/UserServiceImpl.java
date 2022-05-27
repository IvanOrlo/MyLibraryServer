package com.app.sevice;

import com.app.domain.User;
import com.app.sevice.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    @Transactional
    public User insert(User user) {

        return userDao.save(user);
    }


    @Override
    @Transactional
    public User update(int id, String newNameUser) {


        User user = User.builder()
                .id(id)
                .name(newNameUser)
                .build();

        return userDao.save(user);
    }

    @Override
    public List<User> getAll() {

        return userDao.findAll();
    }

    @Override
    public User getById(int id) {

        return userDao.getById(id);
    }

    @Override
    public User getByName(String nameUser) {

        return userDao.findByName(nameUser);
    }

    @Override
    public User getByNameAndPassword(String nameUser, String password) {
        return userDao.getByNameAndPassword(nameUser,password);
    }

    @Override
    @Transactional
    public void deleteById(int id) {

        userDao.deleteById(id);
    }
}
