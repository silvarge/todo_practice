package org.example.todo_practice.service;

import lombok.RequiredArgsConstructor;
import org.example.todo_practice.dto.TodoIdDto;
import org.example.todo_practice.dto.TodoListResDto;
import org.example.todo_practice.dto.TodoReqDto;
import org.example.todo_practice.dto.TodoResDto;
import org.example.todo_practice.entity.Todo;
import org.example.todo_practice.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

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
    public List<TodoListResDto> getAllTitleList() {

        List<Todo> results = todoRepository.getAllTitle();

        return results.stream()
                .map(result -> TodoListResDto.builder()
                        .id(result.getId())
                        .title(result.getTitle())
                        .done(result.isDone())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public TodoResDto getTodoList(int id) {

        Todo result = todoRepository.getDetail((long) id);

        return TodoResDto.builder()
                .id(result.getId())
                .title(result.getTitle())
                .content(result.getContent())
                .done(result.isDone())
                .createdAt(result.getCreatedAt())
                .build();
    }

    @Override
    public TodoIdDto updateTodo(TodoReqDto todo, int id) {
        Todo result = todoRepository.updateContent((long) id, todo);
        return TodoIdDto.builder()
                .id(result.getId())
                .build();
    }

    @Override
    public TodoIdDto updateIsDone(int id) {
        Todo result = todoRepository.updateDone((long) id);
        return TodoIdDto.builder()
                .id(result.getId())
                .build();
    }

    @Override
    public TodoIdDto deleteTodo(int id) {
        Long deleteId = todoRepository.deleteTodo((long) id);
        return TodoIdDto.builder()
                .id(deleteId)
                .build();
    }
}
