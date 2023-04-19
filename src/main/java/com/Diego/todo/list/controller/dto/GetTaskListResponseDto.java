package com.Diego.todo.list.controller.dto;

import com.Diego.todo.list.model.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetTaskListResponseDto {

    private List<Task> taskList;
}
