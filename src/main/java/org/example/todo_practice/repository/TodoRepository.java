package org.example.todo_practice.repository;

import org.example.todo_practice.dto.TodoReqDto;
import org.example.todo_practice.entity.Todo;

import java.util.List;

public interface TodoRepository {
    public Todo saveTodo(Todo todo);

    public Todo getDetail(Long id);

    public List<Todo> getAllTitle();

    public Todo updateContent(Long id, TodoReqDto todoDto);

    public Todo updateDone(Long id);

    public Long deleteTodo(Long id);
}
