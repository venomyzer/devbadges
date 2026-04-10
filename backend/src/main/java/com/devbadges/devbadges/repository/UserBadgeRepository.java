package com.devbadges.devbadges.repository;

import com.devbadges.devbadges.entity.User;
import com.devbadges.devbadges.entity.UserBadge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserBadgeRepository extends JpaRepository<UserBadge, Integer> {

    List<UserBadge> findByUser(User user);

    List<UserBadge> user(User user);
}
