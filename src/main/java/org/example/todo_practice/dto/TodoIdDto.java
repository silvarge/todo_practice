package org.example.todo_practice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
public record TodoIdDto(Long id) {
}
