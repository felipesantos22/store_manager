package com.br.store.service;

import com.br.store.entity.User;
import com.br.store.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUserService(User user) {
        return userRepository.save(user);
    }

    public List<User> readUserService() {
        return userRepository.findAll();
    }

    public Optional<User> readIdService(int id) {
        return userRepository.findById(id);
    }

    public Optional<User> updateService(int id, User user) {
        return userRepository.findById(id).map(record -> {
            record.setName(user.getName());
            return userRepository.save(record);
        });
    }

    public Optional<User> deleteService(int id) {
        return userRepository.findById(id).map(record -> {
            userRepository.deleteById(id);
            return record;
        });

    }

}
