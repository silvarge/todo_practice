package org.example.todo_practice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@Builder
public class TodoListResDto {
    private final Long id;
    private final String title;
    private final boolean done;
}
