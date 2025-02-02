package org.example.todo_practice.repository;

import org.example.todo_practice.entity.Todo;

public interface TodoRepository {
    public Todo saveTodo(Todo todo);

    public Todo getTodoDetail(int index);
}
