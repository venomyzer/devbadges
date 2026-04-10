package com.devbadges.devbadges.service;

import com.devbadges.devbadges.entity.User;
import com.devbadges.devbadges.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findByGithubId(String githubId) { return userRepository.findByGithubId(githubId).orElse(null); }
}
