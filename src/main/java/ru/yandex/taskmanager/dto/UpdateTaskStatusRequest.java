package ru.yandex.taskmanager.dto;

import ru.yandex.taskmanager.model.TaskStatus;

public record UpdateTaskStatusRequest(
        TaskStatus status
){}