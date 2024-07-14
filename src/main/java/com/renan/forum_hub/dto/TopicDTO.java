package com.renan.forum_hub.dto;

import java.time.LocalDateTime;

import com.renan.forum_hub.domain.topic.Topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicDTO(

        Long id,
        @NotBlank String title,
        @NotBlank String message,
        @NotNull LocalDateTime create_at,
        @NotBlank String author,
        @NotBlank String course,
        @NotBlank String state) {

    public TopicDTO(Topic topic) {
        this(topic.getId(),topic.getTitle(), topic.getMessage(), topic.getCreate_at(), topic.getAuthor(),topic.getCourse(), topic.getState());
    }


}
