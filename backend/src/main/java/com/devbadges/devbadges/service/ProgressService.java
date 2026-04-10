package com.devbadges.devbadges.service;

import com.devbadges.devbadges.entity.User;
import com.devbadges.devbadges.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class ProgressService {

    private final UserRepository userRepository;
    private final BadgeService badgeService;

    public ProgressService(UserRepository userRepository , BadgeService badgeService) {
        this.userRepository = userRepository;
        this.badgeService = badgeService;
    }

    public void addXP (User user, long xpEarned) {

        user.setXp(user.getXp() + xpEarned);
        userRepository.save(user);

    }
    public void calculateLevel (User user) {

        long xp = user.getXp();
        int level = (int) (xp / 100);
        user.setLevel(level);
        userRepository.save(user);

    }
    public void updateStreak (User user, LocalDate completedOn) {

        if (user.getLastActivityDate() == null) {
            user.setLastActivityDate(completedOn);
            user.setStreak(1);
            userRepository.save(user);
            return;
        }

        long diff = ChronoUnit.DAYS.between(user.getLastActivityDate(), completedOn);

        if (diff == 0) return;

        if (diff == 1) {
            user.setStreak(user.getStreak() + 1);
        }
        else {
            user.setStreak(1);
        }

        user.setLastActivityDate(completedOn);
        userRepository.save(user);

    }
    public void updateProgress (User user, long xpEarned, LocalDate completedOn) {

        if (user == null) return;

        addXP(user, xpEarned);
        calculateLevel(user);
        updateStreak(user, completedOn);

        badgeService.checkAndAwardBadges(user);

    }

}
