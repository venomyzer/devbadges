package com.devbadges.devbadges.repository;

import com.devbadges.devbadges.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByGithubId(String githubId);

}
