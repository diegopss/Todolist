package com.Diego.todo.list.controller;

import com.Diego.todo.list.controller.dto.GenericResponseWithIdDto;
import com.Diego.todo.list.controller.dto.GetTaskListResponseDto;
import com.Diego.todo.list.model.Task;
import com.Diego.todo.list.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/todolist")
public class TodoListController {

    @Autowired
    TodoListService service;
    @PostMapping("/createtask")
    public ResponseEntity<GenericResponseWithIdDto> createTask(@RequestParam("task") String task){
        Long taskID = service.createTask(task);
        return ok(GenericResponseWithIdDto
                .builder()
                .code("200")
                .title("/createtask")
                .detail("task created sucessfully")
                .id(taskID)
                .build());
    }

    @GetMapping
    public ResponseEntity<GetTaskListResponseDto> getTaskList(){
        return ResponseEntity.ok(service.getTaskList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> getTaskById(@PathVariable(name = "id") Long id){
       return ResponseEntity.ok(service.getTaskById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<GenericResponseWithIdDto> updateTask(@RequestBody Task task){
        Long taskID = service.updateTask(task);
        return ResponseEntity.ok(GenericResponseWithIdDto.builder().code("200").title("/update").detail("task updated sucessfully").id(taskID).build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponseWithIdDto> deleteTask(@PathVariable(name = "id") Long id){
        service.deleteTask(id);
        return ResponseEntity.ok(GenericResponseWithIdDto.builder().code("200").title("/delete").detail("task deleted sucessfully").id(id).build());
    }
}
