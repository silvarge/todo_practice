package org.example.todo_practice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.todo_practice.dto.TodoReqDto;

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

    public Todo updateContent(TodoReqDto updateDto) {
        return this.toBuilder()
                .title(updateDto.getTitle() != null ? updateDto.getTitle() : this.title)
                .content(updateDto.getContent() != null ? updateDto.getContent() : this.content)
                .build();
    }

    public Todo updateIsDone(){
        return this.toBuilder()
                .done(!this.done)
                .build();
    }
}
