package com.renan.forum_hub.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicDTO(
                @NotBlank String title,
                @NotBlank  String message,
                @NotNull   LocalDateTime create_at,
                @NotBlank String author,
                @NotBlank  String course,
                @NotBlank String state
               ) {}
