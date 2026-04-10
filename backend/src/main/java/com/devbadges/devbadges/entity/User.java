package com.devbadges.devbadges.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int user_id;
    @Column(name = "github_id") String githubId;
    String username;
    @Column(name = "avatar_url")    String avatarUrl;
    long xp;
    int level;
    long streak;
    @Column(name = "last_activity_date") LocalDate lastActivityDate;
    @Column(name = "has_starred")   boolean hasStarred;

}
