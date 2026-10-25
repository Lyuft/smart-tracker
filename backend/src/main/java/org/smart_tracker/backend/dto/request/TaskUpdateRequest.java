package org.smart_tracker.backend.dto.request;

import org.smart_tracker.backend.dto.Priority;
import java.time.OffsetDateTime;

public record TaskUpdateRequest(
        String title,
        String description,
        // TODO: Позже реализовать логику переноса задачи (изменение дат)
        OffsetDateTime from,
        OffsetDateTime to,
        Priority priority,
        Boolean isCompleted
) {}
