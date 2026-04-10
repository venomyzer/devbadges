package com.devbadges.devbadges.repository;

import com.devbadges.devbadges.entity.Badge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BadgeRepository extends JpaRepository<Badge, Integer> {
}
