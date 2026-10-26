package ru.yandex.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.taskmanager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}