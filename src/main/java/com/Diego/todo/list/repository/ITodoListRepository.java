package com.Diego.todo.list.repository;

import com.Diego.todo.list.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ITodoListRepository extends JpaRepository<Task, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE todolist SET task = :task, checked = :checked WHERE id = :id", nativeQuery = true)
    void updateTask(@Param("id") Long id, @Param("task")String task, @Param("checked")Boolean checked);
}
