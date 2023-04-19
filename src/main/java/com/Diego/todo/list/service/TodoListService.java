package com.Diego.todo.list.service;

import com.Diego.todo.list.controller.dto.GetTaskListResponseDto;
import com.Diego.todo.list.model.Task;
import com.Diego.todo.list.repository.ITodoListRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class TodoListService {
    @Autowired
    ITodoListRepository repository;
    public Long createTask(String task) {
        log.info("creating a task");
        Task taskCreated =  Task
                .builder()
                .task(task)
                .checked(false)
                .build();
        repository.save(taskCreated);
        return taskCreated.getId();
    }

    public GetTaskListResponseDto getTaskList() {
        return GetTaskListResponseDto.builder().taskList(repository.findAll()).build();

    }

    public Long updateTask(Task task) {
        Long id = task.getId();
        String taskName = task.getTask();
        Boolean checked = task.getChecked();

        repository.updateTask(id,taskName, checked);
        return id;
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    public Optional<Task> getTaskById(Long id) {
        return repository.findById(id);
    }
}
