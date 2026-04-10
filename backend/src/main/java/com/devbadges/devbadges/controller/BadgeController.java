package com.devbadges.devbadges.controller;

import com.devbadges.devbadges.entity.User;
import com.devbadges.devbadges.entity.UserBadge;
import com.devbadges.devbadges.service.BadgeService;
import com.devbadges.devbadges.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/badges")
@CrossOrigin(origins = "http://localhost:5173")
class BadgeController {

    private final BadgeService badgeService;
    private final UserService userService;

    BadgeController(BadgeService badgeService, UserService userService) {
        this.badgeService = badgeService;
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public List<UserBadge> getBadges(@PathVariable int userId) {
        return badgeService.getBadges(userService.getUserById(userId));
    }

}
