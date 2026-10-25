package org.smart_tracker.backend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.smart_tracker.backend.dto.request.TaskRequest;
import org.smart_tracker.backend.dto.request.TaskUpdateRequest;
import org.smart_tracker.backend.dto.response.ApiResponse;
import org.smart_tracker.backend.dto.response.PageData;
import org.smart_tracker.backend.dto.response.TaskResponse;
import org.smart_tracker.backend.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ApiResponse<PageData<TaskResponse>> getAll() {
        List<TaskResponse> tasks = taskService.getAllTasks();
        return ApiResponse.success(PageData.of(tasks));
    }

    @GetMapping("/{id}")
    public ApiResponse<TaskResponse> getById(@PathVariable Long id) {
        return ApiResponse.success(taskService.getTaskById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<TaskResponse> create(@Valid @RequestBody TaskRequest request) {
        return ApiResponse.success(taskService.createTask(request));
    }

    @PutMapping("/{id}")
    public ApiResponse<TaskResponse> update(@PathVariable Long id, @RequestBody TaskUpdateRequest request) {
        return ApiResponse.success(taskService.updateTask(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}