package org.example.todo_practice.repository;

import org.example.todo_practice.common.exception.CustomException;
import org.example.todo_practice.entity.Todo;
import org.example.todo_practice.enums.ErrorCode;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TodoRepositoryImpl implements TodoRepository {

    private final Map<Long, Todo> todoData;

    public TodoRepositoryImpl() {
        // DB 대신 만들어 둠
        this.todoData = new HashMap<>();
    }

    @Override
    public Todo saveTodo(Todo todo) {
        todoData.put(todo.getId(), todo);
        return todo;
    }

    @Override
    public Todo getTodoDetail(int index) {
        if (todoData.containsKey((long) index)) {
            throw new CustomException(ErrorCode.INVALID_INPUT_VALUE);
        }

        return todoData.get((long) index);
    }
}
