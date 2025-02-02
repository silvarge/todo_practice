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

    @PostMapping("/todo")
    public ApiResponse<TodoResDto> registerTodo(@RequestBody TodoReqDto todo) {
        return ApiResponse.created(todoService.registerTodoContent(todo));
    }

    @GetMapping("/todo/list")
    public ApiResponse<TodoResDto> getAllTodoTitle() {
        return ApiResponse.ok(null);
    }

    @GetMapping("/todo")
    public ApiResponse<TodoResDto> getDetailTodo(@RequestParam("id") int id) {
        return ApiResponse.ok(todoService.getTodoList(id));
    }

    @PutMapping("/todo")
    public ApiResponse<TodoResDto> updateTodoContent(@RequestBody TodoReqDto todo) {
        return ApiResponse.ok(null);
    }

    @PostMapping("/todo")
    public ApiResponse<TodoResDto> updateTodoIsDone(@RequestBody int id) {
        return ApiResponse.ok(null);
    }

    @DeleteMapping("/todo")
    public ApiResponse<TodoResDto> deleteTodo(@RequestBody int id) {
        return ApiResponse.ok(null);
    }

}
