package org.example.todo_practice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.todo_practice.common.ApiResponse;
import org.example.todo_practice.dto.TodoIdDto;
import org.example.todo_practice.dto.TodoListResDto;
import org.example.todo_practice.dto.TodoReqDto;
import org.example.todo_practice.dto.TodoResDto;
import org.example.todo_practice.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;

//    Todo 작성 및 등록
    @PostMapping("")
    public ApiResponse<TodoResDto> registerTodo(@RequestBody TodoReqDto todo) {
        return ApiResponse.created(todoService.registerTodoContent(todo));
    }

//    Todo 제목 리스트 조회
    @GetMapping("/list")
    public ApiResponse<List<TodoListResDto>> getAllTodoTitle() {
        return ApiResponse.ok(todoService.getAllTitleList());
    }

//    특정 Todo 상세 조회
    @GetMapping("/{id}")
    public ApiResponse<TodoResDto> getDetailTodo(@PathVariable int id) {
        return ApiResponse.ok(todoService.getTodoList(id));
    }

//    todo 정보 업데이트 (내용)
    @PutMapping("")
    public ApiResponse<TodoIdDto> updateTodoContent(@RequestBody TodoReqDto todo, @RequestParam int id) {
        return ApiResponse.ok(todoService.updateTodo(todo, id));
    }

//    todo 완료 여부 업데이트
    @PatchMapping("")
    public ApiResponse<TodoIdDto> updateTodoIsDone(@RequestParam("id") int id) {
        return ApiResponse.ok(todoService.updateIsDone(id));
    }

//    todo 삭제
    @DeleteMapping("/{id}")
    public ApiResponse<TodoIdDto> deleteTodo(@PathVariable int id) {
        return ApiResponse.ok(todoService.deleteTodo(id));
    }

}
