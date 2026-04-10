package com.devbadges.devbadges.service;

import com.devbadges.devbadges.entity.Task;
import com.devbadges.devbadges.entity.TaskCompletion;
import com.devbadges.devbadges.entity.User;
import com.devbadges.devbadges.repository.TaskCompletionRepository;
import com.devbadges.devbadges.repository.TaskRepository;
import com.devbadges.devbadges.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskCompletionRepository taskCompletionRepository;
    private final UserRepository userRepository;
    private final ProgressService progressService;


    public TaskService(TaskRepository taskRepository, TaskCompletionRepository taskCompletionRepository, UserRepository userRepository, ProgressService progressService) {
        this.taskRepository = taskRepository;
        this.taskCompletionRepository = taskCompletionRepository;
        this.userRepository = userRepository;
        this.progressService = progressService;
    }


    public List<Task> getTasks() {
        return taskRepository.findAll();
    }
    public void completeTask(int taskId, int userId, LocalDate completedOn) {

        User user = userRepository.findById(userId).orElse(null);
        Task task = taskRepository.findById(taskId).orElse(null);

        if (user == null || task == null) return;

        TaskCompletion taskCompletion = new TaskCompletion();
        taskCompletion.setUser(user);
        taskCompletion.setTask(task);
        taskCompletion.setCompleted_on(completedOn);

        taskCompletionRepository.save(taskCompletion);

        progressService.updateProgress(user, task.getXp_reward(), completedOn );

    }


}
