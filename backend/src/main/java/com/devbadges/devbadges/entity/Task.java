package com.devbadges.devbadges.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tasks")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int task_id;
    String description;
    String type;
    String subtype;
    long xp_reward;

}
