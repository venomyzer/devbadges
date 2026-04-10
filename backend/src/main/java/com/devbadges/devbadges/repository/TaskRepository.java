package com.devbadges.devbadges.repository;

import com.devbadges.devbadges.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
