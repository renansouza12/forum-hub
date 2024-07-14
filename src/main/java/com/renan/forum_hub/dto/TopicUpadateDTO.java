package com.renan.forum_hub.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public record TopicUpadateDTO(
        @NotNull Long id,
        String title,
        String message,
        LocalDateTime create_at,
        String author,
        String course,
        String state
    
) {
    
}
