package org.example.todo_practice.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.todo_practice.common.exception.CustomException;
import org.example.todo_practice.dto.TodoReqDto;
import org.example.todo_practice.entity.Todo;
import org.example.todo_practice.enums.ErrorCode;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
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
    public Todo getDetail(Long id) {
        if (!todoData.containsKey(id)) {
            throw new CustomException(ErrorCode.INVALID_INPUT_VALUE);
        }

        return todoData.get(id);
    }

    @Override
    public List<Todo> getAllTitle() {
        return new ArrayList<>(todoData.values());
    }

    @Override
    public Todo updateContent(Long id, TodoReqDto todoDto) {
        Todo result = getDetail(id).updateContent(todoDto);
        todoData.put(id, result);
        return result;
    }

    @Override
    public Todo updateDone(Long id) {
        Todo result = getDetail(id).updateIsDone();
        todoData.put(id, result);
        return result;
    }

    @Override
    public Long deleteTodo(Long id) {
        if(!todoData.containsKey(id)) {
            throw new CustomException(ErrorCode.INVALID_INPUT_VALUE);
        }
        todoData.remove(id);
        return id;
    }
}
