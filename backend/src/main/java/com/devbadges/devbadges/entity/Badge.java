package com.devbadges.devbadges.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "badges")
@Data
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int badge_id;
    String name;
    String description;
    int required_level;
    long required_streak;
    String required_task_type;
    String required_task_subtype;
    int required_task_count;

}
