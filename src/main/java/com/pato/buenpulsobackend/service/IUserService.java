package com.pato.buenpulsobackend.service;

import com.pato.buenpulsobackend.model.User;
import java.util.List;

public interface IUserService {
    User getUser(Long id);
    List<User> getAllUsers();
    void postUser(User user);
    void putUser(User user);
    void deleteUser(Long id);
}
