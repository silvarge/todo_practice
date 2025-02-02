package org.example.todo_practice.service;

import lombok.RequiredArgsConstructor;
import org.example.todo_practice.dto.TodoReqDto;
import org.example.todo_practice.dto.TodoResDto;
import org.example.todo_practice.entity.Todo;
import org.example.todo_practice.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    // 이 친구는 JPA로 나중에 AutoIncrement 적용할 수 있는데 지금은 그 정도까지는 아닌 것 같음
    private static final AtomicLong ID_GENERATOR = new AtomicLong(0);

    @Override
    public TodoResDto registerTodoContent(TodoReqDto todoDto) {

        Todo todo = Todo.builder()
                .id(ID_GENERATOR.getAndIncrement())
                .title(todoDto.getTitle())
                .content(todoDto.getContent())
                .done(todoDto.isDone())
                .build();

        Todo saveTodo = todoRepository.saveTodo(todo);

        return TodoResDto.builder()
                .id(saveTodo.getId())
                .title(saveTodo.getTitle())
                .content(saveTodo.getContent())
                .done(saveTodo.isDone())
                .createdAt(saveTodo.getCreatedAt())
                .build();
    }

    @Override
    public String getTodoOnlyTitleList() {
        return "";
    }

    @Override
    public TodoResDto getTodoList(int index) {

        Todo todo = todoRepository.

        return "";
    }

    @Override
    public String updateTodo(TodoReqDto todo) {
        return "";
    }

    @Override
    public String updateIsDone() {
        return "";
    }

    @Override
    public String deleteTodo() {
        return "";
    }
}
