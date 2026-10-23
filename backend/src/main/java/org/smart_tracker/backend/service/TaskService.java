package org.smart_tracker.backend.service;

import lombok.RequiredArgsConstructor;
import org.smart_tracker.backend.dto.request.TaskRequest;
import org.smart_tracker.backend.dto.response.TaskResponse;
import org.smart_tracker.backend.model.Task;
import org.smart_tracker.backend.repo.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    @Transactional(readOnly = true)
    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(TaskResponse::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public TaskResponse getTaskById(Long id) {
        return taskRepository.findById(id)
                .map(TaskResponse::from)
                .orElseThrow(() -> new RuntimeException("Задача с id " + id + " не найдена"));
    }

    @Transactional
    public TaskResponse createTask(TaskRequest request) {
        Task task = new Task();
        task.setTitle(request.title());
        task.setDescription(request.description());
        return TaskResponse.from(taskRepository.save(task));
    }

    @Transactional
    public TaskResponse updateTask(Long id, TaskRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Задача с id " + id + " не найдена"));

        task.setTitle(request.title());
        task.setDescription(request.description());

        return TaskResponse.from(taskRepository.save(task));
    }

    @Transactional
    public TaskResponse toggleTaskStatus(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Задача с id " + id + " не найдена"));

        task.setCompleted(!task.isCompleted());
        return TaskResponse.from(taskRepository.save(task));
    }

    @Transactional
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Задача с id " + id + " не найдена");
        }
        taskRepository.deleteById(id);
    }
}