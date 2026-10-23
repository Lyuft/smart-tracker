package org.smart_tracker.backend.dto.response;

import org.smart_tracker.backend.model.Task;
import java.time.OffsetDateTime;

public record TaskResponse(
        Long id,
        String title,
        String description,
        boolean isCompleted,
        OffsetDateTime createdAt
) {
    public static TaskResponse from(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted(),
                task.getCreatedAt()
        );
    }
}