package org.example.todo_practice.service;

import org.example.todo_practice.dto.TodoReqDto;
import org.example.todo_practice.dto.TodoResDto;

public interface TodoService {
    TodoResDto registerTodoContent(TodoReqDto todoDto);

    String getTodoOnlyTitleList();

    String getTodoList();

    String updateTodo(TodoReqDto todoDto);

    String updateIsDone();

    String deleteTodo();
}
