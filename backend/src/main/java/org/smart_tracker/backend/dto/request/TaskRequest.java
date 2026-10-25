package org.smart_tracker.backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.smart_tracker.backend.dto.Priority;

import java.time.OffsetDateTime;

public record TaskRequest(
        @NotBlank(message = "Заголовок не может быть пустым")
        @Size(max = 150, message = "Заголовок не должен превышать 150 символов")
        String title,
        String description,
        OffsetDateTime from,
        OffsetDateTime to,
        Priority priority
) {}