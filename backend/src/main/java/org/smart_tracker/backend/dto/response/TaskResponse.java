package org.smart_tracker.backend.dto.response;

import org.smart_tracker.backend.dto.Priority;
import org.smart_tracker.backend.model.Task;
import java.time.OffsetDateTime;

public record TaskResponse(
        Long id,
        String title,
        String description,
        Priority priority,
        OffsetDateTime from,
        OffsetDateTime to,
        boolean isCompleted, // ДОБАВИЛИ
        OffsetDateTime createdAt
) {
    public static TaskResponse from(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getPriority(),
                task.getFromDate(),
                task.getToDate(),
                task.isCompleted(),
                task.getCreatedAt()
        );
    }
}