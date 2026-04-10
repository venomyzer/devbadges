package com.devbadges.devbadges.service;

import com.devbadges.devbadges.entity.Badge;
import com.devbadges.devbadges.entity.User;
import com.devbadges.devbadges.entity.UserBadge;
import com.devbadges.devbadges.repository.BadgeRepository;
import com.devbadges.devbadges.repository.TaskCompletionRepository;
import com.devbadges.devbadges.repository.UserBadgeRepository;
import com.devbadges.devbadges.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BadgeService {

    private final BadgeRepository badgeRepository;
    private final UserBadgeRepository userBadgeRepository;
    private final TaskCompletionRepository taskCompletionRepository;
    private final UserRepository userRepository;



    public BadgeService(BadgeRepository badgeRepository, UserBadgeRepository userBadgeRepository , UserRepository userRepository, TaskCompletionRepository taskCompletionRepository) {
        this.badgeRepository = badgeRepository;
        this.userBadgeRepository = userBadgeRepository;
        this.userRepository = userRepository;
        this.taskCompletionRepository = taskCompletionRepository;
    }

    public List<UserBadge> getBadges(User user) {
        return userBadgeRepository.findByUser(user);
    }

    public void checkAndAwardBadges(User user) {

        if (user == null) return;

        List<Badge> allBadges = badgeRepository.findAll();

        for (Badge badge : allBadges) {

            if (user.getLevel() >= badge.getRequired_level()
                    && user.getStreak() >= badge.getRequired_streak()
                    && taskCompletionRepository.countByUserAndTask_Subtype(user, badge.getRequired_task_subtype()) >= badge.getRequired_task_count()) {

                UserBadge userBadge = new UserBadge();

                userBadge.setUser(user);
                userBadge.setBadge(badge);
                userBadge.setEarned_on(LocalDate.now());
                userBadgeRepository.save(userBadge);

            }
        }
    }


}
