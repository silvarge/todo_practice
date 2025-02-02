package org.example.todo_practice.service;

import org.example.todo_practice.dto.TodoIdDto;
import org.example.todo_practice.dto.TodoListResDto;
import org.example.todo_practice.dto.TodoReqDto;
import org.example.todo_practice.dto.TodoResDto;

import java.util.List;

public interface TodoService {
    TodoResDto registerTodoContent(TodoReqDto todoDto);

    List<TodoListResDto> getAllTitleList();

    TodoResDto getTodoList(int id);

    TodoIdDto updateTodo(TodoReqDto todoDto, int id);

    TodoIdDto updateIsDone(int id);

    TodoIdDto deleteTodo(int id);
}
