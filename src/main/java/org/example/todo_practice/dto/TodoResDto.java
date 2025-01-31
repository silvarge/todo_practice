package org.example.todo_practice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

@Getter
@AllArgsConstructor
@ToString
@Builder
public class TodoResDto {
    private final Long id;
    private final String title;
    private final String content;
    private final boolean done;
    private final Instant createdAt;
}
