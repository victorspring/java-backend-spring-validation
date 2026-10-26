package ru.yandex.taskmanager.dto;

public record CreateTaskRequest(
        String title,
        String description
){}