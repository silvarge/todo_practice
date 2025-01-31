package org.example.todo_practice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TodoReqDto {
    private String title;
    private String content;

    @Builder.Default
    private boolean done = false;
}
