package com.devbadges.devbadges.controller;

import com.devbadges.devbadges.entity.User;
import com.devbadges.devbadges.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
class AuthController {

    private final UserService userService;

    AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/success")
    public void handleAuthSuccess(
            @AuthenticationPrincipal OAuth2User oAuth2User,
            HttpServletResponse response) throws IOException {

        Object idAttribute = oAuth2User.getAttribute("id");
        if (idAttribute == null) { response.sendRedirect("http://localhost:5173"); return; }

        String githubId = idAttribute.toString();
        String username = oAuth2User.getAttribute("login");
        String avatarUrl = oAuth2User.getAttribute("avatar_url");

        User existingUser = userService.findByGithubId(githubId);

        if (existingUser != null) {
            response.sendRedirect("http://localhost:5173/dashboard?userId=" + existingUser.getUser_id());
            return;
        }

        User newUser = new User();
        newUser.setGithubId(githubId);
        newUser.setUsername(username);
        newUser.setAvatarUrl(avatarUrl);
        newUser.setXp(0);
        newUser.setLevel(0);
        newUser.setStreak(0);
        newUser.setHasStarred(false);

        User saved = userService.createUser(newUser);
        response.sendRedirect("http://localhost:5173/dashboard?userId=" + saved.getUser_id());
    }

}

