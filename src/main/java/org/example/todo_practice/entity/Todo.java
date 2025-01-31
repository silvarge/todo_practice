package org.example.todo_practice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Todo {
    private Long id;
    private String title;
    private String content;
    private boolean done;

    @Builder.Default
    private Instant createdAt = Instant.now();
}
