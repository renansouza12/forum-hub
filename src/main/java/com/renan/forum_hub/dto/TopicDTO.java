package com.renan.forum_hub.dto;

import jakarta.validation.constraints.NotBlank;

public record TopicDTO(
               @NotBlank String title,
               @NotBlank  String message,
               @NotBlank String author,
               @NotBlank  String course) {}
