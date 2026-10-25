package org.smart_tracker.backend.exception;

public record ErrorResponse(
        int code,
        boolean success,
        String message,
        String title
) {}
