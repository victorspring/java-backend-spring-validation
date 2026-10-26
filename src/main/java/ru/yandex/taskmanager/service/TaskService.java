package ru.yandex.taskmanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.taskmanager.dto.CreateTaskRequest;
import ru.yandex.taskmanager.dto.UpdateTaskStatusRequest;
import ru.yandex.taskmanager.exception.TaskNotFoundException;
import ru.yandex.taskmanager.model.Task;
import ru.yandex.taskmanager.repository.TaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task createTask(CreateTaskRequest request) {
        Task task = new Task(
                request.title(),
                request.description()
        );

        return taskRepository.save(task);
    }

    public Task updateStatus(Long id, UpdateTaskStatusRequest request) {
        Task task = getTask(id);
        task.setStatus(request.status());

        return taskRepository.save(task);
    }
}