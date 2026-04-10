package com.devbadges.devbadges.controller;

import com.devbadges.devbadges.entity.Task;
import com.devbadges.devbadges.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:5173")
class TaskController {

    private final TaskService taskService;

    TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping()
    public List getTasks() {
        return taskService.getTasks();
    }

    @PostMapping()
    public void completeTask(@RequestParam int taskId,
                             @RequestParam int userId,
                             @RequestParam LocalDate completedOn) {
        taskService.completeTask(taskId, userId, completedOn);
    }
}
