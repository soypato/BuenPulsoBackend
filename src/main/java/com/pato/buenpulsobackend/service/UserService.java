package com.pato.buenpulsobackend.service;

import com.pato.buenpulsobackend.model.User;
import com.pato.buenpulsobackend.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void postUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void putUser(User user) {
        if (getUser(user.getIdUser()) != null) {
            userRepository.save(user);
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
