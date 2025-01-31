package org.example.todo_practice.controller;

import lombok.AllArgsConstructor;
import org.example.todo_practice.common.ApiResponse;
import org.example.todo_practice.dto.TodoReqDto;
import org.example.todo_practice.dto.TodoResDto;
import org.example.todo_practice.service.TodoService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class TodoController {
    private final TodoService todoService;

    @GetMapping()
    public String test(){
        return "TEST";
    }

    @PostMapping("/todo")
    public ApiResponse<TodoResDto> registerTodo(@RequestBody TodoReqDto todo) {
        return ApiResponse.created(todoService.registerTodoContent(todo));
    }

}
