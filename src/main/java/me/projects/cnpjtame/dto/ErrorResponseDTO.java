package me.projects.cnpjtame.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorResponseDTO (
        int status,
        String message,
        LocalDateTime timestamp
) {
}
