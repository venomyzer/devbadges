package com.devbadges.devbadges.repository;

import com.devbadges.devbadges.entity.TaskCompletion;
import com.devbadges.devbadges.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskCompletionRepository extends JpaRepository<TaskCompletion, Integer> {

    int countByUserAndTask_Subtype(User user, String subtype);

}
